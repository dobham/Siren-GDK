class MapCreate{
    private int mapHeight;
    private int mapWidth;
    public double xDist;
    public double yDist;
    public int xTile;
    public int yTile;
//    ArrayList<ArrayList<Integer>> gridArray = new ArrayList<ArrayList<Integer>>();

    public MapCreate(){
        mapHeight = (int)(Math.random() *10);
        mapWidth = (int)(Math.random() *10);
        xDist = 50;
        yDist = 50;
        yTile = ((int)Math.floor(mapHeight/2));
        xTile = ((int)Math.floor(mapWidth/2));
        int[][] gridArray = new int[mapHeight+2][mapWidth+2];
    }
    public MapCreate(int y, int x){
        mapHeight = y;
        mapWidth = x;
        xDist = 50;
        yDist = 50;
        int[][] gridArray = new int[mapHeight+2][mapWidth+2];
    }
    public MapCreate(int y, int x, int startPosX, int startPosY){
        mapHeight = y;
        mapWidth = x;
        xDist = 50;
        yDist = 50;
        xTile = startPosX;
        yTile = startPosY;
        int[][] gridArray = new int[mapHeight+2][mapWidth+2];
    }
    public void setSpawn(int[][] gridArray){
        gridArray[xTile][yTile] = 3;
    }
    public int[][] createGrid(int[][] gridArray){
//        MapCreate spawnValue = new MapCreate(5,5,2,2);
//        int[][] spawnGrid = spawnValue.setSpawn(gridArray);
        for(int h = 0; h<mapHeight+2; h++){
            for(int x = 0; x< mapWidth+2; x++){
                if(h == 0 || h == mapHeight+1){
                    for(int xy = 0; xy<mapWidth; xy++){
                        gridArray[h][x] = 1;
                    }
                }
                else if( (h != 0 && h != mapHeight+1) && (x == 0 || x == mapWidth+1) ){
                    gridArray[h][x] = 1;
                }
                else{
                    if(gridArray[h][x] == 3){
                        continue;
                    }
                    gridArray[h][x] = ((int)(Math.random() *10) >= 6 ? 1 : 0);
                }
            }
        }
        return gridArray;
    }
}