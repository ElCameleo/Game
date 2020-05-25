for (int i = 0 ; i < worldGrid.length ; i++) {
	for (int j = 0 ; j < worldGrid.length ; j++) {
        
        if (worldGrid[i][j] == 1){
            
            // Diagonale haut gauche
            if ((worldGrid[i-1][j-1] == 1) && ((worldGrid[i-1][j] != 0) || (worldGrid[i][j-1] != 0))){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i-1, j-1)), 1);
            } 

            // Ouest        
            else if (worldGrid[i][j-1] == 1){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i, j-1)), 1);
            } 

            // Diagonale bas gauche        
            else if ((worldGrid[i+1][j-1] == 1) && ((worldGrid[i][j-1] != 0) || (worldGrid[i+1][j] != 0))){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i+1, j-1)), 1);
            } 

            // Nord        
            else if (worldGrid[i-1][j] == 1){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i-1, j)), 1);
            } 

            // Est        
            else if (worldGrid[i][j+1] == 1){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i, j+1)), 1);
            }

            // Diagonale haut droit        
            else if ((worldGrid[i-1][j+1] == 1) && ((worldGrid[i-1][j] != 0) || (worldGrid[i][j+1] != 0))){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i-1, j+1)), 1);
            } 

            // Sud        
            else if (worldGrid[i+1][j] == 1){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i+1, j)), 1);
            } 

            // Diagonale bas droit        
            else if ((worldGrid[i+1][j+1] == 1) && ((worldGrid[i+1][j] != 0) || (worldGrid[i][j+1] != 0))){
                graph.addEdge(vecToInt(new Vector(i, j)), vecToInt(new Vector(i+1, j+1)), 1);
            }
        }
	}
}