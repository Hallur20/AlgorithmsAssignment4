
<h1>Assignemnt 4 Algorithms <g-emoji class="g-emoji" alias="airplane" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/2708.png">✈️</g-emoji></h1>

<p>This project contains 4 algorithms:</p>

<ul>
  <li>DepthFirstSearch</li>
  <li>BreadthFirstSearch</li>
  <li>Dijkstra with distance & time</li>
  <li>Minimum spanning tree (that algorthm is not full completed, it does not work as it should...)</li>
</ul>

<h1>Setup <g-emoji class="g-emoji" alias="checkered_flag" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f3c1.png">🏁</g-emoji></h1>
<p>The project is made in java, we used netbeans IDE, to run the program do the following steps:</p>

<p>1-Clone the project</p>

<p>2-We use algs4 so you need to add the algs4 jar file to the project which you can download her <a href="https://algs4.cs.princeton.edu/code/algs4.jar">algs4 jar file.</a></p>

<p>3-After adding the algs4 jar file build the project then go to the <a href="https://github.com/Hallur20/AlgorithmsAssignment4/blob/master/src/Main.java">main class.</a></p>

<h1>What the main class contains <g-emoji class="g-emoji" alias="link" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f517.png">🔗</g-emoji></h1>

<p>The main class contain the code to run the 3 diffrent algorthms (DepthFirstSearch, BreadthFirstSearch, Dijkstra with distance & time) with the needed files from the assignemnt.</p>

<p>To run one of the algorithms all you need after doing the steps in the "Setup" section, is just to comment out the algorthm you want to see then run the main.</p>

<p>The main does not contain the code to run the "Minimum spanning tree" algorithms becaouse we did not manage to make it work sadly... </p>

<h1>Data Structure</h1>

<p>The way we make the algorithms work, is that we do alot of searching with for-loops through the string array that splits a semicolumn from the file. We have also been using the "queue" system from the book, which makes us able to enqueue/dequeue (you can say they have to do with inserting and deleting) the nodes we wish to do something with. Mostly the inputs required are a starting-point, end-point and then the actual string array. We believe that there were room for improvements (in areas such as making a used list larger to improve memory) and therefore the complexities go from O=(n) in depth/breadth search, to o=log(n) in dijkstra/minimum spanningtree.</p>

