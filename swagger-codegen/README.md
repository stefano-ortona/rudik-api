# Installation

* Eclipse: https://github.com/RepreZen/SwagEdit
* Codegen: Run the fetch.sh script or follow instructions at https://github.com/swagger-api/swagger-codegen

# Generating Server code

* To INITIALIZE, run ONCE the generate-server.sh ARTIFACT_ID where ARTIFACT_ID is the ID of the artifact in the generate pom.xml. 
	- This will generate in swagger-codegen/.. all necessary files. Existing files will NOT be overwritten, so ideally should be empty.
	- You might want to edit the POM file. Also the config.json contains the package names for the API/model etc. which you might want to adjust. 
* To regenerate the code, use regenerate-server.sh. 
    - WARNING: This is supposed to overwrite stuff. It should only overwrite in gen/, but still be careful. 
    - WARNING: This will overwrite anything in gen/. To avoid that either add --skip-overwrites to the script. 
    - If you have not run the first script, you need to create a config.json in swagger-codegen/ with 
{
	"modelPackage": "asu.edu.$ARTIFACT_ID.model",
	"apiPackage" : "asu.edu.$ARTIFACT_ID",
	"invokerPackage" : "asu.edu.$ARTIFACT_ID"
}
where $ARTIFACT_ID is the ID of the artifact as above (or whatever package names you prefer).