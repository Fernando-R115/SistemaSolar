package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public Spatial traslacion;
    public Spatial rotacion_1;
    public Spatial rotacion_2;
    public Spatial rotacion_3;
    public Spatial rotacion_4;
    public Spatial rotacion_5;
    public Spatial traslacion2;
    public Spatial traslacion3;
    public Spatial traslacion4;
    public Spatial traslacion5;
    public Spatial traslacion6;
    
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Sistema Solar");
        settings.setSettingsDialogImage("Textures/sistema.jpg");
        settings.setResolution(1920, 1080);
        settings.setVSync(true);
        settings.setFrameRate(60);
        settings.setFullscreen(true);
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        Node nodo_Sol = new Node("nodo_Sol");
        Node nodo_Tierra = new Node("nodo_Tierra");
        Node nodo_Luna = new Node("nodo_Luna");
        Node nodo_Marte = new Node("nodo_Marte");
        Node nodo_Jupiter = new Node("nodo_Jupiter");
        Node nodo_Saturno = new Node("nodo_Saturno");
        Node nodo_Urano = new Node("nodo_Urano");
        Node nodo_Traslacion2 = new Node("nodo_Traslacion2");
        Node nodo_Traslacion3 = new Node("nodo_Traslacion3");
        Node nodo_Traslacion4 = new Node("nodo_Traslacion4");
        Node nodo_Traslacion5 = new Node("nodo_Traslacion5");
        Node nodo_Traslacion6 = new Node("nodo_Traslacion6");
        
        flyCam.setMoveSpeed(30f);
        
        cam.setLocation(new Vector3f(0,0,50));
        /**
         * DECLARAR ESFERAS
         * DECLARAMOS EL SOL COMO UNA ESFERA
         */
        Sphere sol = new Sphere(30,30,4);
        Geometry geom_Sol = new Geometry("Sol",sol);
        
        /**
         * DECLARAMOS OTRA ESFERA
         * DECLARAMOS LA TIERRA COMO UNA ESFERA
         */
        Sphere tierra = new Sphere(30,30,2);
        Geometry geom_Tierra = new Geometry("Tierra",tierra);
        
        /**
         * DECLARAMOS LA LUNA
         */
        Sphere luna = new Sphere(30,30,1);
        Geometry geom_Luna = new Geometry("Luna",luna);
        
        /**
         * DECLARAMOS A MARTE
         */
        
        Sphere marte = new Sphere(30,30,3);
        Geometry geom_Marte = new Geometry("Marte",marte);
        
        /**
         * DECLARAMOS A JUPITER
         */
        
        Sphere jupiter = new Sphere(30,30,7);
        Geometry geom_Jupiter = new Geometry("Jupiter",jupiter);
        
        /**
         * DECLARAMOS A SATURNO
         */
        
        Sphere saturno = new Sphere(30,30,6);
        Geometry geom_Saturno = new Geometry("Saturno",saturno);
        
        /**
         * DECLARAMOS A URANO
         */
         
        Sphere urano = new Sphere(30,30,3);
        Geometry geom_Urano = new Geometry("Urano",urano);
        
        /**
         * AGREGAMOS LOS COLORES A LAS ESFERAS
         */
        Material mat_Sol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Sol.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        geom_Sol.setMaterial(mat_Sol);

        Material mat_Tierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Tierra.setTexture("ColorMap", assetManager.loadTexture("Textures/planeta_tierra.jpg"));
        geom_Tierra.setMaterial(mat_Tierra);
        
        Material mat_Luna = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Luna.setTexture("ColorMap", assetManager.loadTexture("Textures/luna.jpg"));
        geom_Luna.setMaterial(mat_Luna);
        
        Material mat_Marte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Marte.setTexture("ColorMap", assetManager.loadTexture("Textures/marte.jpg"));
        geom_Marte.setMaterial(mat_Marte);
        
        Material mat_Jupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Jupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter.jpg"));
        geom_Jupiter.setMaterial(mat_Jupiter);
        
        Material mat_Saturno = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Saturno.setTexture("ColorMap", assetManager.loadTexture("Textures/saturno.jpg"));
        geom_Saturno.setMaterial(mat_Saturno);
        
        Material mat_Urano = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_Urano.setTexture("ColorMap", assetManager.loadTexture("Textures/urano.jpg"));
        geom_Urano.setMaterial(mat_Urano);
        
        /**
         * AGREGAMOS LAS GEOMETRIAS A CADA NODO CORRESPONDIENTE
         */
        nodo_Tierra.attachChild(geom_Tierra);
        nodo_Luna.attachChild(geom_Luna);
        nodo_Marte.attachChild(geom_Marte);
        nodo_Jupiter.attachChild(geom_Jupiter);
        nodo_Saturno.attachChild(geom_Saturno);
        nodo_Urano.attachChild(geom_Urano);
        
        /**
         * AÑADIMOS LOS NODOS A EL SOL PARA QUE GIREN TODOS 
         * ALREDEDOR DEL NODO DEL SOL
         */
        //nodo_Sol.attachChild(nodo_Tierra);
        nodo_Traslacion2.attachChild(nodo_Tierra);
        nodo_Tierra.attachChild(nodo_Luna);
        nodo_Traslacion3.attachChild(nodo_Marte);
        nodo_Traslacion4.attachChild(nodo_Jupiter);
        nodo_Traslacion5.attachChild(nodo_Saturno);
        nodo_Traslacion6.attachChild(nodo_Urano);
        
        /**
         * MOVEMOS LA LUNA Y LA TIERRA 
         */
        
        
        nodo_Luna.move(4, 0, 0);
        nodo_Tierra.move(10, 0, 0);
        nodo_Marte.move(20,0,0);
        nodo_Jupiter.move(40,0,0);
        nodo_Jupiter.rotate(FastMath.DEG_TO_RAD*90, 0, 0);
        nodo_Saturno.rotate(FastMath.DEG_TO_RAD*90, 0, 0);
        nodo_Saturno.move(50,0,0);
        nodo_Urano.move(60,0,0);
        
        /**
         * AÑADIMOS AL NODO RAIZ
         */
        
        rootNode.attachChild(nodo_Sol);
        rootNode.attachChild(geom_Sol);
        rootNode.attachChild(nodo_Traslacion2);
        rootNode.attachChild(nodo_Traslacion3);
        rootNode.attachChild(nodo_Traslacion4);
        rootNode.attachChild(nodo_Traslacion5);
        rootNode.attachChild(nodo_Traslacion6);
        
        /**
         * 
         */
        
    }

    /**
     * Para que giren los nodos
     * @param tpf 
     */
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        if(traslacion == null || rotacion_1 == null || rotacion_2 == null){
            System.out.println("No esta asignado el objeto");
            traslacion = rootNode.getChild("nodo_Sol");
            traslacion2 = rootNode.getChild("nodo_Traslacion2");
            traslacion3 = rootNode.getChild("nodo_Traslacion3");
            traslacion4 = rootNode.getChild("nodo_Traslacion4");
            traslacion5 = rootNode.getChild("nodo_Traslacion5");
            traslacion6 = rootNode.getChild("nodo_Traslacion6");
            rotacion_1 = rootNode.getChild("nodo_Tierra");
            rotacion_2 = rootNode.getChild("nodo_Marte");
            rotacion_3 = rootNode.getChild("nodo_Jupiter");
            rotacion_4 = rootNode.getChild("nodo_Saturno");
            rotacion_5 = rootNode.getChild("nodo_Urano");
        }
        else{
            /**
             * Aquí rotamos todo
             */
            //Para que giren los planetas
            traslacion.rotate(0,tpf,0);
            traslacion2.rotate(0, (float) (tpf*0.5),0);
            traslacion3.rotate(0, (float) (tpf*0.7),0);
            traslacion4.rotate(0,(float) (tpf*1.0),0);
            traslacion5.rotate(0,(float) (tpf*1.3),0);
            traslacion6.rotate(0,(float) (tpf*1.5),0);
            //Rotación sobre su propio eje de los planetas
            rotacion_1.rotate(0,tpf,0);
            rotacion_2.rotate(0,tpf,0);
            rotacion_3.rotate(0,0,(float)(tpf*5.0));
            rotacion_4.rotate(0,0,(float)(tpf*4.5));
            rotacion_5.rotate(0,tpf,0);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
