# Dijkstra-Alvin-Jorkey

Java Programm that implements Dijkstra's algorithm using a priority Queue and maps to store data. The program is given a file as input which represents either a directed or undirected graft. All the vertices of the graph are listed in the file as well as the edges with weights. For example, 1 line of input will read "edge seattle Denver 2161" meaning the two vertices are seattle and denver and the edge weight(or distance) between these two points is 2161. Once ran, a trace will be given of Dijkstra's algorithm on the graph. At the end of this trace, the shortest path will be printed along with the cummulative shortest distance on this path. The final distance map and the final previous map are also given

Here's an example run on graph3.txt

Visiting vertex los_angeles

  Updating dist[san_francisco] from 2147483647 to 629
  
  Updating dist[las_vegas] from 2147483647 to 435

Visiting vertex las_vegas
  Updating dist[denver] from 2147483647 to 1660
  
  Updating dist[dallas] from 2147483647 to 2418

Visiting vertex san_francisco
  Updating dist[seattle] from 2147483647 to 1935

Visiting vertex denver
  Updating dist[minneapolis] from 2147483647 to 3143

Visiting vertex seattle

Visiting vertex dallas
  Updating dist[miami] from 2147483647 to 4579
  
  Updating dist[washington_dc] from 2147483647 to 4531

Visiting vertex minneapolis
  Updating dist[chicago] from 2147483647 to 3804

Visiting vertex chicago
  Updating dist[boston] from 2147483647 to 5417

Visiting vertex washington_dc
  Updating dist[boston] from 5417 to 5256
  
  Updating dist[new_york] from 2147483647 to 4914

Visiting vertex miami

Visiting vertex new_york
  Updating dist[boston] from 5256 to 5252

Visiting vertex boston

Shortest path is: los_angeles las_vegas dallas washington_dc new_york boston

Distance is: 5252
