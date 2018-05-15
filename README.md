# Intro
Inversor de Palavras Online construído em Java 8 (inversão no backend).

# DataBase
`CREATE TABLE `Palavras` (
  `Texto` varchar(500) DEFAULT NULL,
  `TextoInvertido` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1`
# Build
mvn clean package && docker build -t vapstor/Bridge .

# RUN

docker rm -f Bridge || true && docker run -d -p 8080:8080 -p 4848:4848 --name Bridge vapstor/Bridge 
