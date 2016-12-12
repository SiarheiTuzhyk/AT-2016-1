echo off
echo "Hello! This is installer of vagrant box of ubuntu, which consist WordPress server."
echo "Installing of VM."
cd vagrant_wordpress
vagrant up
echo "End to install VM."
echo "---------------------------------------"
cd ..
cd FinalProjectAutoTests
echo "Start of autotests!"
mvn clean test
echo "End of tests. Thanks for using our product. Having a nice day!"
pause