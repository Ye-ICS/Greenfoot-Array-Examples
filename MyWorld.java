import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Square[] squares;
    AnimationWithArrays animatedCharacter;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        squares = new Square[10];
        
        for (int i = 0; i < squares.length; i++)
        {
            squares[i] = new Square();
        }
        
        // Instructions.
        showText("Press ENTER to add squares.", 300, 20);
        showText("Click anywhere to move squares.", 300, 50);
        showText("Press DELETE to remove squares.", 300, 80);
        
        
        // Add animated character.
        animatedCharacter = new AnimationWithArrays();
        addObject(animatedCharacter, 550, 350);
    }
    
    
    public void act()
    {
        moveSquares();
        
        if (Greenfoot.isKeyDown("delete"))
        {
            removeSquares();
            // Delay 10 frames to avoid detecting key press multiple times.
            Greenfoot.delay(10);
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            addSquares();
            // Delay 10 frames to avoid detecting key press multiple times.
            Greenfoot.delay(10);
        }
        
        if (Greenfoot.isKeyDown("r"))
        {
            rearrangeSquares();
            // Delay 10 frames to avoid detecting key press multiple times.
            Greenfoot.delay(10);
        }
    }
    
    
    /**
     * Moves squares to position of mouse click, arranging them in a pattern.
     */
    public void moveSquares()
    {
        if (Greenfoot.mousePressed(this) == false)
        {
            // Mouse not pressed on world, so end this method and return.
            return;
        }
        
        // TODO: Ideally, should also check that the squares are still in the world.
        
        
        // Otherwise, if mouse was pressed:
        int mouseX = Greenfoot.getMouseInfo().getX();
        int mouseY = Greenfoot.getMouseInfo().getY();
        
        // Move the squares to a position relative to the mouse click.
        for (int i = 0; i < squares.length; i++)
        {
            int x = 30 * i + mouseX;
            int y = -20 * i + mouseY;
            squares[i].setLocation(x, y);
        }
    }
    
    
    /**
     * Removes squares from world.
     */
    public void removeSquares()
    {
        // TODO: Ideally, should check that they are still in the world.
        
        for (int i = 0; i < squares.length; i++)
        {
            removeObject(squares[i]);
        }
    }
    
    
    /**
     * Adds squares to world.
     */
    public void addSquares()
    {
        // TODO: Ideally, should check that they aren't already added to the world.
        
        for (int i = 0; i < squares.length; i++)
        {
            int x = 30 * i + 20;
            int y = -20 * i + 350;
            addObject(squares[i], x, y);
        }
    }
    
    /**
     * Re-arranges squares in a different pattern.
     */
    public void rearrangeSquares()
    {
        // TODO: Ideally, should check that they are still in the world.
        
        int x0 = squares[0].getX();
        int y0 = squares[0].getY();
        
        int middle = squares.length / 2;
        // Re-arrange second half of squares.
        for (int i = middle; i < squares.length; i++)
        {
            int x = 30 * (i - middle) + x0;
            int y = 20 * i + y0 - 180;
            squares[i].setLocation(x, y);
        }
    }
}
