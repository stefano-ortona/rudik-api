#!/bin/sh
if [ "$#" -ne 2 ]; then
	echo 'generate-client PROJECT_DIRECTORY ARTEFACT_ID'
	return 1
fi

BASEPATH=$(dirname $0)

CODEGEN=$BASEPATH/codegen

CODEGEN_CONFIG_FILE=$BASEPATH/config.json

INPUT_DIR=$1

INPUT_FILE=$INPUT_DIR/rudik-api_swagger.yaml

OUTPUT_DIR=$INPUT_DIR/client

mkdir -p $OUTPUT_DIR

SWAGGER_IGNORE_FILE=$OUTPUT_DIR/.swagger-codegen-ignore

ARTIFACT_ID=$2

cat <<EOF > $SWAGGER_IGNORE_FILE
# Swagger Codegen Ignore
# Lines beginning with a # are comments

# This should match build.sh located anywhere.

# Matches build.sh in the root
#/build.sh
/.gitignore
/git_push.sh
/gradle/**
/gradle*
/gradle/wrapper
/gradel/wrapper*
/.travis.yml
/gradle/wrapper/gradle-wrapper.properties
/build.sbt
/settings.gradle
/build.gradle

# Exclude all recursively
#docs/**

# Explicitly allow files excluded by other rules
#!docs/UserApi.md

# Recursively exclude directories named Api
# You can't negate files below this directory.
#src/**/Api/

# When this file is nested under /Api (excluded above),
# this rule is ignored because parent directory is excluded by previous rule.
#!src/**/PetApiTests.cs

# Exclude a single, nested file explicitly
#src/IO.Swagger.Test/Model/AnimalFarmTests.cs
EOF

cat <<EOF > config.json
{
	"modelPackage": "asu.edu.$ARTIFACT_ID.model",
	"apiPackage" : "asu.edu.$ARTIFACT_ID.api",
	"invokerPackage" : "asu.edu.$ARTIFACT_ID.service",
	"library": "jersey2"
}
EOF

$CODEGEN generate -i $INPUT_FILE \
	--lang java \
	--config $CODEGEN_CONFIG_FILE \
	--output $OUTPUT_DIR

