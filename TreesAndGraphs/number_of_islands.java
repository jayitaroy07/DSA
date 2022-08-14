class Solution {
    public int numIslands(char[][] grid) {
        
        int no_of_island = 0;
        
        // If the Grid is null or empty, return 0
        if(grid==null || grid.length < 1){
            return no_of_island;
        }
        
        // Grid traversal
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col] == '1'){
                    no_of_island++;
                    dfs(grid, row, col);
                }
            }
        }
        
        return no_of_island;
        
    }
    
    public void dfs(char[][] grid, int row, int col){
        // base case || boundary condition
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0'){
            return;
        }
        
        // update the vising nodes to '0'
        grid[row][col] = '0';
        
        // traversal
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
        
    }
}

/*
In DFS we will be travering all the nodes in the Graph at max 1
Time Complexity : o(rowxcol)
Space Complexity : o(rowxcol)
*/
