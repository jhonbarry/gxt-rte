/**
 * @TODO: Documentation of 
 * User: Peter Quiel <peter.quiel@pq-solutions.de>
 * Date: 25.09.2008
 * Time: 11:26:10
 */

import deploy.Deployer;

String env = (args.length > 0) ? args[0] : "test";

Deployer.deploy(new File("./properties/editor.properties"), env);