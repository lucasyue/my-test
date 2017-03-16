1.不含package、不设置环境变量时
JAVA_HOME\bin目录，javac、java执行ok
2.含package执行，javac可以指定绝对路径也可以使用javac编译本目录java文件，
但执行java命令时，所执行的文件要在包目录中，并且命令执行时含包路径。
3.java命令执行时classpath默认包含当前目录.;。
4.classpath为java执行时搜索class文件的位置，可以通过set classpath设置。编译的文件使用到的类都需要包含在classpath中。