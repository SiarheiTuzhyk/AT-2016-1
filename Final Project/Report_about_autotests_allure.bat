echo off
echo "-----------------------------------------"
cd FinalProjectAutoTests
mvn site
cd target\site\allure-maven-plugin
echo "Open report file!"
index.html
echo "End of program. Thanks for using our product. Having a nice day!"
pause