@echo off
call mvn clean package
call docker build -t daw2/ChessJSP .
call docker rm -f ChessJSP
call docker run -d -p 9080:9080 -p 9443:9443 --name ChessJSP daw2/ChessJSP