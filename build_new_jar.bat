javac -cp lib/\* src/excelreader/*.java -d bin 
javadoc -cp lib/\* src/excelreader/*.java -d docs
jar cvfm excelreader.jar .\resources\manifest.txt -C bin . src docs
