package com.pack.diplomap.MapObjects;

import java.awt.*;

public class DevText
{


Texts mouse, world, rightGrab, razn, vec,leftGrab,leftTouch;

  public DevText()
  {
      world=(new Texts("world",new MyPoint(0,0),0));
      mouse=(new Texts("mouse",new MyPoint(0,0),1));
      rightGrab=(new Texts("RightGrab",new MyPoint(0,0),2));
      razn=(new Texts("Razn",new MyPoint(0,0),3));
      vec=(new Texts("Vec",new MyPoint(0,0),4));
      leftGrab=(new Texts("leftGrab",new MyPoint(0,0),5));
      leftTouch=(new Texts("leftTouch",new MyPoint(0,0),6));
  }

  public void tick(Point world,Point mouse,Point rightGrab,Point razn,Point vec,Point leftGrab,Point leftTouch)
  {
      /*
      this.world.tick(world);
      this.mouse.tick(mouse);
      this.rightGrab.tick(rightGrab);
      this.razn.tick(razn);
      this.vec.tick(vec);
      this.leftGrab.tick(leftGrab);
      this.leftTouch.tick(leftTouch);
*/
  }

  public void render(Graphics g)
  {
      world.render(g);
      mouse.render(g);
      rightGrab.render(g);
      razn.render(g);
      vec.render(g);
      leftGrab.render(g);
      leftTouch.render(g);


  }

}
