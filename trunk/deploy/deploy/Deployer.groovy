/**
 * Copyright 2008 Peter Quiel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package deploy

import groovy.util.AntBuilder


/**
 * This script comiles gwt applications, recompresses image bundles and copies the javascript files to a target directory
 * 
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 03.11.2008
 * Time: 13:38:11
 */

class Deployer {

    static deploy(File propertyFile, String environment) {

        Properties buildProp = new Properties();

        println "Environment: $environment";
        if (!propertyFile.exists()) {
            System.exit(0);
        }

        buildProp.load(new FileInputStream(propertyFile))

        println "Property file readed:"
        buildProp.each {key, value ->
            println "$key : $value"
        }

        /* getting the constants from porperites */
        def app = buildProp.get("app")
        def target = buildProp.get("target");
        def convert = buildProp.get("convert")
        def gwtHome = buildProp.get("gwtHome")
        def buildDir = buildProp.get("buildDir")
        def completeBuildDir = "$buildDir/$app"
        def constant = buildProp.get("constant");
        def ant = new AntBuilder()

        def constantFileName
        def envConstantFileName
        def gwtConstantFileName

        if(constant){
            constantFileName = "../src/${constant}.properties";
            envConstantFileName = "../src/${constant}_${environment}.properties";
            gwtConstantFileName = "../src/${constant}_gwt.properties";
            ant.sequential {
                echo("Copying property file $envConstantFileName to $constantFileName");
                copy(file:envConstantFileName, tofile:constantFileName, overwrite:true)
            }
        }

        def classPath = ant.path {
            fileset(dir: gwtHome) {
                include(name: "*.jar")
            }
            fileset(dir: "../lib") {
                include(name: "*.jar")
            }
            pathelement(path: "../src")
        }


        ant.java(classpath: "$classPath", classname: "com.google.gwt.dev.GWTCompiler", fork: 'true') {
            jvmarg(value: "-Xmx256M")
            arg(value: "-out")
            arg(value: buildDir)
            arg(value: "\$@")
            arg(value: app)
        }

        println "Recompressing png files, if this fails .."
        File appDir = new File(completeBuildDir);
        try {
            appDir.eachFile {file ->
                if (file.getName().endsWith('.png') && file.fontSize() > 10000) {
                    println "Recomporessing ${file.getAbsolutePath()} size: ${file.fontSize()}"
                    "$convert ${file.getAbsolutePath()} ${file.getAbsolutePath()}".execute().waitFor()
                    println "Size after recompressing ${new File(file.getAbsolutePath()).size()}"
                }
            }
        } catch (Exception e) {
            println "png Files could not compressed. The ImageMagick convert program could not be found.\n"
        }

        ant.sequential {
            echo("Copy compiled js files to $target")

            copy(todir: target) {
                fileset(dir: completeBuildDir) {
                    include(name: "**")
                }
            }
            echo("clean up!")
            delete(dir: buildDir)
            echo("done!")
            if(constant){
                echo("Restoring gwt constant file")
                copy(file:gwtConstantFileName, tofile: constantFileName, overwrite:true)
            }
        }


    }
}