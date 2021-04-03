echo "compile ./src"
javac -classpath .:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar:/run_dir/json-simple-1.1.1.jar  src/*.java -d ./bin
#echo "run Main.java"
