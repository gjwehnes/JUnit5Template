echo "compile ./src"
javac -classpath .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar:/run_dir/json-simple-1.1.1.jar:./Jars/*  src/*.java -d ./bin

echo "run Test4.java"
java -classpath .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar:/run_dir/json-simple-1.1.1.jar:./bin ManualTest4

echo "run Test5.java"
java -jar "./Jars/junit-platform-console-standalone-1.5.0.jar" --disable-banner --disable-ansi-colors --details-theme=ascii --details=tree -class-path ./bin -c GameOfLifeTest

echo "run Test5.java"
java -jar "./Jars/junit-platform-console-standalone-1.5.0.jar" --disable-banner --disable-ansi-colors --details-theme=ascii --details=tree -class-path ./bin -c TriangleClassifierTest5

#echo "run Test5.java"
#java -classpath .:./jars/*:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar:/run_dir/json-simple-1.1.1.jar:./bin ManualTest5

#javac -classpath .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar:/run_dir/json-simple-1.1.1.jar:./Jars/*  *.java -d ./bin

#java -jar "./Jars/junit-platform-console-standalone-1.5.0.jar" --disable-banner --disable-ansi-colors --details-theme=ascii --details=tree -class-path ./bin -c TriangleClassifierTest5
