# AAL_Algorytmy_Grafowe
Projekt z przedmiotu AAL EiTI PW dotyczący algorytmów grafowych

Project calculating how many Scouts does the King has to ask in order to know everything about the battlefield, considering the fact that every single scout can give all the information he knows to just one scout. Whole project is written in Java, using JHM library for benchmarking and Python mini-project creating a pdf with the graph representing King's scouts.

1. In order to compile project make sure you have maven installed. Go into AAL_Algorytmy
    _Grafowe/AAL/ directory and then run 

        $mvn clean install
        
   to compile whole project and create target directory with compiled classes and benchmarks.jar for benchmarking.
   If you encounter troubles with maven-surefire-plugin try running

      $mvn dependency:tree

2. In order to run application head to AAL/target/classes/ directory. You will find all compiled classes there.
   To build your graph and test it immediately run this command

		$java program.GraphGenerator <Number_of_Nodes> | java program.Main
	
   Replace <Number_of_Nodes> with number of nodes you want to be used when creating your program.Graph .
   You should be able to see demanding output in your console.

3. Alternatively, you can run 

		$java program.GraphGenerator <Number_of_Nodes> > in.txt
	
   This will create or overwrite file in.txt. This file will contain all the data about your Graph. You will be given three files with pre-generated graph. ( in.txt - 100 nodes, in1.txt - 10000 nodes, in2.txt - 100000 nodes )
   
   Next you have to run
   
		$java program.Main < in.txt > out.txt
	
   And you will see the result stored in out.txt file. You can ommit '> out.txt' part,
   then you will get your output visible in the console.

4. If you would like to run benchmarks of two used algorythms, then after compiling a project head into AAL/target directory. Now simply run

		$java -jar benchmarks.jar

   !WARNING: Keep in mind that this benchmark is running tests on the AAL/target/classes/in.txt graph. 
5. In order to visualize your graph go into AAL_Algorytmy_Grafowe/Python/ folder, then run 

		$python visualizer.py <path_of_file_with_graph>
		
   This module uses graphviz library so make sure that you install it before running that command.

   Replace <path_of_file_with_graph> with path of the file with your graph, that you want to be printed.
   
   Your graph will appear in graph.gv.pdf file and should open automatically.
    
   For bigger graphs you will probably have to wait a minute or few so please be patient :) .

