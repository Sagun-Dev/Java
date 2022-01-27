**Assigned Date: 2022/01/07** &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
**Deu Date:2022/01/14**

# APPLET
## Applet Life Cycle in Java
![Applet Life cycle](https://static.javatpoint.com/core/images/applet-life-cycle-in-java.png)

In Java, an applet is a special type of program embedded in the web page to generate dynamic content. Applet is a class in Java.

The applet life cycle can be defined as the process of how the object is created, started, stopped, and destroyed during the entire execution of its application. It basically has five core methods namely `init()`, `start()`, `stop()`, `paint()` and `destroy()`.These methods are invoked by the browser to execute.

Along with the browser, the applet also works on the client side, thus having less processing time.

## Methods of Applet Life Cycle
There are five methods of an applet life cycle, and they are:
- init()

The `init()` method is the first method to run that initializes the applet. It can be invoked only once at the time of initialization. The web browser creates the initialized objects, i.e., the web browser (after checking the security settings) runs the `init()` method within the applet.

- start()

The `start()` method contains the actual code of the applet and starts the applet. It is invoked immediately after the `init()` method is invoked. Every time the browser is loaded or refreshed, the start() method is invoked. It is also invoked whenever the applet is maximized, restored, or moving from one tab to another in the browser. It is in an inactive state until the `init()` method is invoked.

- stop()

The `stop()` method stops the execution of the applet. The stop () method is invoked whenever the applet is stopped, minimized, or moving from one tab to another in the browser, the `stop()` method is invoked. When we go back to that page, the `start()` method is invoked again.

- destroy()

The `destroy()` method destroys the applet after its work is done. It is invoked when the applet window is closed or when the tab containing the webpage is closed. It removes the applet object from memory and is executed only once. We cannot start the applet once it is destroyed.

- paint()

The `paint()` method belongs to the Graphics class in Java. It is used to draw shapes like circle, square, trapezium, etc., in the applet. It is executed after the `start()` method and when the browser or applet windows are resized.
 

# JAVA SWING 
Java Swing is a part of Java Foundation Classes (JFC) that is used to create window-based applications. It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java.

Unlike AWT, Java Swing provides platform-independent and lightweight components.

The javax.swing package provides classes for java swing API such as JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser etc.

## Difference		  											
<table border = "1">
    <tr>
        <td>AWT</td>
        <td>Swing</td>
    </tr>
	<tr>
        <td>AWT components are platform-dependent.</td>
        <td>Swing components are platform-independent.</td>
    </tr>
    <tr>
        <td>AWT components are heavyweight.</td>
        <td>Swing components are lightweight.</td>
    </tr>
    <tr>
        <td>AWT doesn't support pluggable look and feel.</td>
        <td>Swing supports pluggable look and feel.</td>
    </tr>
    <tr>
        <td>AWT provides less components than Swing.</td>
        <td>Swing provides more components than AWT.</td>
    </tr>
    <tr>
        <td>AWT doesn't follows MVC(Model view Controller) where model represents data, view represents and controller acts as an interface between model and view.</td>
        <td>Swing follows MVC(Model view Controller) where model represents data, view represents presentation and controller acts as an interface between model and view.</td>
    </tr>
</table>
