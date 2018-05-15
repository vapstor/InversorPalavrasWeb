FROM airhacks/glassfish
COPY ./target/Bridge.war ${DEPLOYMENT_DIR}
