@echo off

rem YOUR JAVA CONFIGS HERE
set JAVA_EXE="java"

:generateProto
echo Do you want to generate proto? (y/n)
set /p userChoice=Enter choice: 
if /i "%userChoice%"=="y" goto processProto
if /i "%userChoice%"=="n" goto buildJar

:processProto
echo Generating protocol buffers...
call gradlew generateproto
if %ERRORLEVEL% neq 0 goto end
goto buildJar

:buildJar
echo Building JAR...
call gradlew jar
if %ERRORLEVEL% neq 0 goto end

:execute
echo Executing JAR...
call java -jar your-application.jar
goto end

:end
echo Operation completed.