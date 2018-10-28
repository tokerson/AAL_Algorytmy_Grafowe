
1. You can run this using Generator, in order to do so run terminal and use this command

		$java Generator.GraphGenerator <Number_of_Nodes> | java Main
	
   Replace <Number_of_Nodes> with number of nodes you want to be used when creating your Graph .

2. Alternatively, you can run 

		$java Generator.GraphGenerator <Number_of_Nodes> > in.txt
	
   This will create or overwrite file in.txt. This file will contain all the data about your Graph.
   
   Next you have to run
   
		$java Main < in.txt > out.txt
	
   And you will see the result stored in out.txt file. You can ommit '> out.txt' part. 
   
   Then you will get your output visible in the console.


