package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;

public class SecondLevelBorder2 {
        private int screenWidth,screenHeight;
        private int numberOfRooms, x1, y1, x2, y2, x3, y3, x4, y4, scale;
        private int totalX, totalY, levelWidthSize, levelHeightSize, normalRooms, index;
        private int x, y, i, a, a2;
        private int YAssetParts, XAssetParts, maxX, maxY;
        private int xz1, xz2, xz3, xz4;
        private int yz1, yz2, yz3, yz4;
        private int newX, newY, newA;
        private int width, height;
        private int XFloorParts;
        private int currentHeightWallLeft, currentHeightWallRight, currentWidthWallTop, heightWallBottom;
        private boolean itemroom, k;
        Graphics g;
        private Backgroundaccessoires acc;
        //private Randomizer randomizer; (Randomassets in weißer Voraussicht)


    public SecondLevelBorder2(int numberOfRooms, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int scale, boolean itemroom, Graphics g) {
                this.numberOfRooms = numberOfRooms;
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
                this.x3 = x3;
                this.y3 = y3;
                this.x4 = x4;
                this.y4 = y4;
                this.scale = scale;
                this.itemroom = itemroom;
                this.g = g;

                Variables();
            }


            public int getTotalY() {
                return totalY;
            }

            public void setTotalY(int totalY) {
                this.totalY = totalY;
            }

            public void Variables() {

                Toolkit tk = Toolkit.getDefaultToolkit();
                screenWidth = tk.getScreenSize().width;
                screenHeight = tk.getScreenSize().height;

                totalX = x1 + x2 + x3 + x4;
                totalY = y1 + y2 + y3 + y4;

                levelWidthSize = numberOfRooms * screenWidth;
                levelHeightSize = numberOfRooms * screenHeight;

                width = 16;
                height = 16;
                i = 0;
                newA = 0;

                currentHeightWallLeft = height;
                currentHeightWallRight = height;

                currentWidthWallTop = width;

                k = false;

                //if(itemroom == true) {normalRooms = numberOfRooms - 1;} else normalRooms = numberOfRooms;
                normalRooms = 0;

                CreateBorder();

            }

            public void CreateBorder() {

                if(itemroom == true) {
                    x = screenWidth/2;
                    y = screenHeight/2;
                }

                for(i = 0; normalRooms < numberOfRooms; normalRooms++) {
                    index = normalRooms;
                    switch(index) {
                        case(0):
                            x = x1;
                            y = y1;
                            newX = x;
                            newY = y;
                            a = 0;
                            a2 = 0;
                            acc = new Backgroundaccessoires(x,y,a, a2,g);
                            BorderLeftRight();
                            acc.FirstLevel();
                            break;
                        case(1):
                            x = x2;
                            y = y2;
                            a += heightWallBottom + width;
                            a2 = 0;
                            acc = new Backgroundaccessoires(x,y, a , a2,g);
                            BorderLeftRight();
                            acc.SecondLevel();
                            break;
                        case(2):
                            x = x3;
                            y = y3;
                            a2 += -x2;
                            acc = new Backgroundaccessoires(x,y, a, a2, g);
                            BorderLeftRight();
                            acc.ThirdLevel();
                            break;
                        case(3):
                            x = x4;
                            y = y4;
                            a += heightWallBottom + height;
                            acc = new Backgroundaccessoires(x,y,a, a2, g);
                            BorderLeftRight();
                            acc.FourthLevel();
                            break;
                        default:
                            break;
                    }
                }
            }

            public void BorderLeftRight() {

                YAssetParts = (int) Math.ceil(y / (16d * scale)) - 1; //Number of Tiles y total height except corner tile bottom
                XAssetParts = (int) Math.ceil(x / (16d * scale)) - 2; //Number of Tiles x Corners will be added by left and right wall
                XFloorParts = (int) Math.ceil(x / (16d * scale)) - 4;

                maxX = x / scale;
                maxY = y / scale;

                for(;YAssetParts > 0; YAssetParts--) {

                    if(i > 1) {i = 0;}
                    g.drawImage(Assets.wallLeft[i], 0 + ((1920 - x)/10 + (a2/5)), currentHeightWallLeft - height + a, null);   //create wall left
                    g.drawImage(Assets.wallRight[i],  (1920)/5 - width - ((1920 - x)/10) + a2/5, currentHeightWallLeft - height + a , null); //create wall right
                    currentHeightWallLeft += height;
                    i++;
                }
                currentHeightWallLeft -= height;
                i = 0;
                StaticBorder(currentHeightWallLeft);
                BorderTopBottom(currentHeightWallLeft);
            }

            public void StaticBorder( int currentHeightWallLeft) {
                g.drawImage(Assets.cornerLB, 0 + ((1920 - x)/10) + a2/5, currentHeightWallLeft + a, null); //static corner left bottom
                g.drawImage(Assets.cornerRB, 1920/5 - width - ((1920 - x)/10) + a2/5, currentHeightWallLeft + a, null); //static corner right bottom
            }

            public void BorderTopBottom(int heightWallBottom) {
                this.heightWallBottom = heightWallBottom;

                for(;XAssetParts > 0; XAssetParts--) {
                    if(i > 2){i = 0;}

                    if(k == false) {
                        if (XFloorParts < ((int) Math.ceil(x / (16 * scale)) - 4) / 2 || XFloorParts > ((int) Math.ceil(x / (16 * scale)) - 4) / 2 + 1) {
                            g.drawImage(Assets.wallTop[i], currentWidthWallTop + ((1920 - x) / 10) + a2 / 5, 0 + a, null); //create wall top
                            g.drawImage(Assets.wallBottom[i], currentWidthWallTop + ((1920 - x) / 10) + a2 / 5, heightWallBottom + a, null); //create wall bottom
                            currentWidthWallTop += width;
                            i++;
                        } else {
                            currentWidthWallTop += width;
                            i++;
                        }
                    }
                }
                currentWidthWallTop = width;
                currentHeightWallLeft = height;
                i = 0;


                //TODO:
                // Raumkoordinaten der 5 Räume ausrechnen
                // Randomize- Wert ausgeben
                // An Randomizestelle Asset reinpacken
                //g.drawImage(Assets.randomitems[i], width + ((1920 - x)/10) + a2/5, height + a, null);
                //g.drawImage(Assets.boxes[4], width + ((1920 - x)/10) + a2/5 + 32, height + a + 16, null);


                if(a2 == 0 || a2 == newA){newY += heightWallBottom + height;
                } else {newX += a2;}
                //backgroundaccessoires = new Backgroundaccessoires(newX,newY,g);
                newA = a2;
            }

    public void FloorCorners( int currentHeightWallLeft) {
        currentWidthFloor = width;
        currentHeightFloor = height;
        currentWidthFloorTB = width;
        currentHeightFloorTB = height;
        g.drawImage(Assets.floorLT, currentWidthFloor + (1920 - x)/10, currentHeightFloor + a, null); //create Floor
        g.drawImage(Assets.floorRT, x / scale - (2 * width) + (1920 - x)/10, currentHeightFloor + a , null); //create Floor
        g.drawImage(Assets.floorLB, currentWidthFloor + (1920 - x)/10, currentHeightWallLeft - height + a, null); //create Floor
        g.drawImage(Assets.floorRB, x / scale - 2 * width + (1920 - x)/10, currentHeightWallLeft - height +a , null); //create Floor

        for(; YFloorParts > 0; YFloorParts--) {
            g.drawImage(Assets.floorLeft, currentWidthFloor + (1920 - x)/10, currentHeightFloor + a + height, null); //create Floor
            g.drawImage(Assets.floorRight, x / scale - (2 * width) + (1920 - x)/10, currentHeightFloor + a + height, null); //create Floor
            currentHeightFloor += height;
        }
        for(; XFloorParts > 0; XFloorParts--) {

            if (i > 1) {i = 0;}

            if(XFloorParts < ((int) Math.ceil(x / (16 * scale)) -4)/2|| XFloorParts > ((int) Math.ceil(x / (16 * scale)) - 4)/2+1) {
                g.drawImage(Assets.floorBottom[i], currentWidthFloorTB + (1920 - x) / 10 + width, currentHeightWallLeft - height + a, null); //create Floor
                g.drawImage(Assets.floorTop[i], currentWidthFloorTB + (1920 - x) / 10 + width, height + a, null); //create Floor
                currentWidthFloorTB += width;
                i++;
            } else {
                g.drawImage(Assets.floorCenter[i], currentWidthFloorTB + ((1920 - x) / 10) + width, currentHeightWallLeft - height + a, null);
                g.drawImage(Assets.floorCenter[i], currentWidthFloorTB + ((1920 - x) / 10) + width, height + a, null);
                currentWidthFloorTB += width; i++;
            }
        }
        XFloorParts = (int) Math.ceil(x / (16 * scale)) - 4;
        YFloorParts = (int) Math.ceil(y / (16 * scale)) - 3;

        currentWidthFloor = width;
        currentHeightFloor = height;
        for (; YFloorParts > 0; YFloorParts--) {

            for (; XFloorParts > 0; XFloorParts--) {
                if (i > 11) {
                    i = 0;
                }
                g.drawImage(Assets.floorCenter[i], currentWidthFloor + width + (1920 - x)/10, currentHeightFloor + height + a, null); //create Floor
                currentWidthFloor += width;
                i++;
            }
            currentWidthFloor = width;
            currentHeightFloor += height;
            XFloorParts = (int) Math.ceil(x / (16 * scale)) - 4;
        }
    }
        }
