/*
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []] 
 * Output: [[0,1,3],[0,2,3]] 
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Note:
 *
 *     The number of nodes in the graph will be in the range [2, 15].
 *         You can print different paths in any order, but you should keep the order of nodes inside one path.
 *
 *
 */
class allPathsSourceTarget{
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        // Build Graph using HashMap
        Map<Integer, List<Integer>> g = new HashMap();

        for(int i=0; i<n; i++){
            if(!g.containsKey(i)){
                g.put(i,new ArrayList<>());
            }

            for (int j=0; j<graph[i].length;j++){
                g.get(i).add(graph[i][j]);
            }
        }

        //Define variables for processing
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        //Add Source to the path
        path.add(0);
        vivisted[0] = true;

        //Recursively call DFS util
        dfs(0, n-1, visited, g, path,res);
    }

    private void dfs(int v, int end, boolean[] visited, Map<Integer, List<Integer>> g,
                    List<Integer> path, List<List<Integer>> res) {

        if(v == end) {
            res.add(new ArrayList<>(path));
            return;
        }

        List<Integer> next = g.get(v);
        if(next == null)
            return;

        for(int x : next){
            if(!visited[x]){
                vivited[x] = true;
                dfs(x,end,visited,g,path,res);
                path.remove(path,size()-1);
                visited[x] = false;
            }
        }
    }
}
