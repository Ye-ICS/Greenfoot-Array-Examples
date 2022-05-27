import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animations using arrays of images.
 */
public class AnimationWithArrays extends Actor
{
    /**
     * Movement variables.
     */
    boolean isFacingRight = true;
    
    /**
     * Animation variables.
     */
    int animationInterval = 10;  // Number of frames between animation images.
    int frameCounter = 0;       // Frame counter. For animations.
    
    /**
     * Arrays for animation images.
     */
    GreenfootImage[] imagesWalkRight;
    GreenfootImage[] imagesWalkLeft;
    GreenfootImage[] imagesIdleRight;
    GreenfootImage[] imagesIdleLeft;
    
    
    public AnimationWithArrays()
    {
        loadImages();
    }
    
    
    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            isFacingRight = true;
            animate(imagesWalkRight);
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            isFacingRight = false;
            animate(imagesWalkLeft);
        }
        else if (isFacingRight == true)
        {
            animate(imagesIdleRight);
        }
        else
        {
            animate(imagesIdleLeft);
        }
    }
    
    
    /**
     * Animates using the specified images.
     */
    void animate(GreenfootImage[] images)
    {
        if (frameCounter >= images.length * animationInterval)  // Greater or equal (>=) takes care of animations with different number of images.
        {
            frameCounter = 0;
        }
        
        if (frameCounter % animationInterval == 0)  // If it's time to switch to next animation image.
        {
            setImage(images[frameCounter/animationInterval]);
        }
        
        frameCounter++;
    }
    
    
    /**
     * Loads images used for animations.
     */
    void loadImages()
    {
        imagesWalkRight = new GreenfootImage[6];
        imagesWalkLeft = new GreenfootImage[6];
        imagesIdleRight = new GreenfootImage[4];
        imagesIdleLeft = new GreenfootImage[4];
        
        for (int i = 0; i < imagesWalkRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "3 SteamMan/Walk/tile" + i + ".png";
            imagesWalkRight[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Again, assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "3 SteamMan/Idle/tile" + i + ".png";
            imagesIdleRight[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i].mirrorHorizontally();
        }
    }
}
