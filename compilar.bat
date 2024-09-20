javac -cp lib\ojdbc11.jar -d bin src\entidades\*.java src\Main.java

if %ERRORLEVEL% neq 0 (
    pause
)


