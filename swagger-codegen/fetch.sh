#!/bin/sh
# Fetch URL as of Nov 02, 2016

wget http://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.2.1/swagger-codegen-cli-2.2.1.jar -O swagger-codegen-cli.jar


cat <<EOF > codegen
#!/bin/sh
# --- Generated file, will be overwritten by fetch.sh ---
# Runs SWAGGER code generator 

java -jar $PWD/swagger-codegen-cli.jar \$@
EOF

chmod a+x codegen
