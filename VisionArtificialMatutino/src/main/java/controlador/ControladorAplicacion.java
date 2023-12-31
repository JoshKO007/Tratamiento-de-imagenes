package controlador;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import modelo.*;
import vista.*;


public class ControladorAplicacion implements ActionListener{
    private ImageFFT transformedImage;
    private Principal objVentanaPrincipal;
    private Imagen objImagenFuente;
    private Imagen objImagenProcesada;
    private Operaciones objOperacion;
    private File archivoImagen;
    private PanelPropiedades panelPropiedades;
    private PanelUmbralizacion objUmbralizacion;
    private PanelConvolucion objConvolucion;
    private PanelContraArmonica objContraarmonica;

    public ControladorAplicacion(Principal objVentana){
        this.objVentanaPrincipal = objVentana;
        this.objUmbralizacion = new PanelUmbralizacion();
        this.objConvolucion = new PanelConvolucion();
        this.objContraarmonica = new PanelContraArmonica();
        this.objConvolucion.buttonAplicar.addActionListener(this);
        this.objUmbralizacion.jButton1.addActionListener(this);
        this.objUmbralizacion.Combo1.addActionListener(this);
        this.objVentanaPrincipal.menuItemAbrir.addActionListener(this);
        this.objVentanaPrincipal.menuItemEscalaGrises.addActionListener(this);
        this.objVentanaPrincipal.menuItemOriginal.addActionListener(this);
        this.objVentanaPrincipal.menuItemRotar90.addActionListener(this);
        this.objVentanaPrincipal.menuItem180.addActionListener(this);
        this.objVentanaPrincipal.menuItem270.addActionListener(this);
        this.objVentanaPrincipal.menuItemTraslacion.addActionListener(this);
        this.objVentanaPrincipal.menuItemSumaEscalar.addActionListener(this);
        this.objVentanaPrincipal.menuItemRestaEscalar.addActionListener(this);
        this.objVentanaPrincipal.menuItemReflexionX.addActionListener(this);
        this.objVentanaPrincipal.menuItemReflexionY.addActionListener(this);
        this.objVentanaPrincipal.menuItemSuma.addActionListener(this);
        this.objVentanaPrincipal.menuItemResta.addActionListener(this);
        this.objVentanaPrincipal.menuItemUm.addActionListener(this);
        this.objVentanaPrincipal.jMenuItemAnd.addActionListener(this);
        this.objVentanaPrincipal.jMenuItemNot.addActionListener(this);
        this.objVentanaPrincipal.jMenuItemOr.addActionListener(this);
        this.objVentanaPrincipal.jMenuItemXor.addActionListener(this);
        this.objVentanaPrincipal.menuItemCon.addActionListener(this);
        this.objVentanaPrincipal.jMenuAritmetica.addActionListener(this);
        this.objVentanaPrincipal.jMenuMediaG.addActionListener(this);
        this.objVentanaPrincipal.jMenuContra.addActionListener(this);
        this.objContraarmonica.jButtonCalcular.addActionListener(this);
        this.objVentanaPrincipal.jMenuItemMediana.addActionListener(this);
        this.objVentanaPrincipal.jMenuMax.addActionListener(this);
        this.objVentanaPrincipal.jMenuMinimo.addActionListener(this);
        this.objVentanaPrincipal.jMenuMedio.addActionListener(this);
        this.objVentanaPrincipal.jMenuAdaptativo.addActionListener(this);
        this.objVentanaPrincipal.jMenuTransformar.addActionListener(this);
        this.objVentanaPrincipal.jMenuEspectro.addActionListener(this);
        this.objVentanaPrincipal.jMenuILPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuBLPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuIHPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuBHPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuIBPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuIBSF.addActionListener(this);
        this.objVentanaPrincipal.jMenuBBPF.addActionListener(this);
        this.objVentanaPrincipal.jMenuBBSF.addActionListener(this);
        this.objVentanaPrincipal.jManuDilatacion.addActionListener(this);
        this.objVentanaPrincipal.jMenuErosion.addActionListener(this);
        this.objVentanaPrincipal.jMenuApertura.addActionListener(this);
        this.objVentanaPrincipal.jMenuCierre.addActionListener(this);
        this.objVentanaPrincipal.jMenuGuardar.addActionListener(this);
        this.objVentanaPrincipal.jMenuCreditos.addActionListener(this);
        this.objVentanaPrincipal.jMenuCalcularHistograma.addActionListener(this);
        this.objVentanaPrincipal.jMenuVerHistograma.addActionListener(this);
        this.objVentanaPrincipal.jMenuRtoC.addActionListener(this);
        this.objVentanaPrincipal.jMenuCtoR.addActionListener(this);
        this.objVentanaPrincipal.jMenuRtoH.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Abrir Imagen")){
            abrirArchivoImagen();
            System.out.println("Seleccionaste Abrir Imagen"); 
        }
        if(e.getActionCommand().equals("Escala Grises")){
            convertirEscalaGrises();
            System.out.println("Seleccionaste Escala Grises"); 
        }
        if (e.getActionCommand().equals("Original")) {
            mostrarImagenOriginal();
            System.out.println("Seleccionaste Original");
        }
        if (e.getActionCommand().equals("Rotar 90°")) {
            rotar90Grados();
            System.out.println("Seleccionaste Rotar 90°");
        }
        if (e.getActionCommand().equals("Rotar 180°")) {
            rotar180Grados();
            System.out.println("Seleccionaste Rotar 180°");
        }
        if (e.getActionCommand().equals("Rotar 270°")) {
            rotar270Grados();
            System.out.println("Seleccionaste Rotar 270°");
        }     
        if (e.getActionCommand().equals("Traslacion")) {
            System.out.println("Seleccionaste Traslacion");            
        try {
            String desplazamientoStr = JOptionPane.showInputDialog("Ingrese el valor de traslación:");
            int desplazamiento = Integer.parseInt(desplazamientoStr);
            trasladar(desplazamiento);
            
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar un valor de traslación");
        }
        }
        if (e.getActionCommand().equals("Suma Escalar")) {
            System.out.println("Seleccionaste Suma Escalar");
            
        try {
            String puntos = JOptionPane.showInputDialog("Ingrese el valor de suma:");
            int brillo = Integer.parseInt(puntos);
            sumarEscalar(brillo);
            
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar un valor");
        }
        }     
        if (e.getActionCommand().equals("Resta Escalar")) {         
            System.out.println("Seleccionaste Resta Escalar");
        try {
            String puntos = JOptionPane.showInputDialog("Ingrese el valor de resta:");
            int oscuro = Integer.parseInt(puntos);
            restarEscalar(oscuro);   
            
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar un valor");
        }
        }     
        if (e.getActionCommand().equals("Reflexion X")) {
            reflexionX();
            System.out.println("Seleccionaste Reflexion X");
        }     
        if (e.getActionCommand().equals("Reflexion Y")) {
            reflexionY();
            System.out.println("Seleccionaste Reflexion Y");
        }      
        if (e.getActionCommand().equals("Suma")) {
            suma();
            System.out.println("Seleccionaste Suma");
        }      
        if (e.getActionCommand().equals("Resta")) {
            resta();
            System.out.println("Seleccionaste Resta");
        }   
        if (e.getActionCommand().equals("Umbralización")){
            objVentanaPrincipal.jPanel1.removeAll();
            objVentanaPrincipal.jPanel1.setLayout(new BorderLayout());
            objVentanaPrincipal.jPanel1.add(objUmbralizacion, BorderLayout.CENTER);
            System.out.println("Seleccionaste umbralización");
        }
        if (e.getActionCommand().equals("Convolución")){
            objVentanaPrincipal.jPanel1.removeAll();
            objVentanaPrincipal.jPanel1.setLayout(new BorderLayout());
            objVentanaPrincipal.jPanel1.add(objConvolucion, BorderLayout.CENTER);
            System.out.println("Seleccionaste convolución");
        }        
        if (e.getActionCommand().equals("Aplicar")) {
                String opcion = objUmbralizacion.Combo1.getSelectedItem().toString();
            switch (opcion) {
                case "Inverso":
                    negativo();
                    System.out.println("Estas en la opcion Inverso");
                    break;
                case "Umbral":
                    System.out.println("Estas en la opcion Umbral");
                    umbral();
                    break;
                case "Umbral inverso":
                    System.out.println("Estas en la opcion Umbral inverso");
                    umbralInv();
                    break;
                case "Intervalo de umbral":
                    System.out.println("Estas en la opcion Intervalo de umbral");
                    intUmbral();
                    break;
                case "Intervalo de umbral inverso":
                    System.out.println("Estas en la opcion de Intervalo de umbral inverso");
                    intUmbralIn();
                    break;
                case "Intervalo de umbral en gris":
                    System.out.println("Estas en la opcion de Intervalo de umbral gris");
                    intUmbralG();
                    break;
                case "Intervalo de umbral en gris inverso":
                    System.out.println("Estas en la opcion de Intervalo de umbral gris inverso");
                    intUmbralGI();
                    break;
                default:
                    break;
            }
            System.out.println("Seleccionaste Aplicar");
        }
        if (e.getActionCommand().equals("AND")){
            AND();
            System.out.println("Seleccionaste AND");
        }
        if (e.getActionCommand().equals("OR")){
            OR();
            System.out.println("Seleccionaste OR");
        }
        if (e.getActionCommand().equals("NOT")){
            NOT();
            System.out.println("Seleccionaste NOT");
        }
        if (e.getActionCommand().equals("XOR")){
            XOR();
            System.out.println("Seleccionaste XOR");
        }       
        if (e.getActionCommand().equals("Aplicar filtro")){
            convolucion();
            System.out.println("Seleccionaste aplicar filtro");
        }
        if (e.getActionCommand().equals("Media aritmetica")){
            mediaAritmetica();
            System.out.println("Seleccionaste media aritmetica");
        }
        if (e.getActionCommand().equals("Media geometrica")){
            mediaGeometrica();
            System.out.println("Seleccionaste media aritmetica");
        } 
        if (e.getActionCommand().equals("Media contra-armonica")){
            objVentanaPrincipal.jPanel1.removeAll();
            objVentanaPrincipal.jPanel1.setLayout(new BorderLayout());
            objVentanaPrincipal.jPanel1.add(objContraarmonica, BorderLayout.CENTER);
            System.out.println("Seleccionaste contra armonica");
        } 
        if (e.getActionCommand().equals("Calcular")){
            contraArmonica();
            System.out.println("Seleccionaste calcular");
        }
        if (e.getActionCommand().equals("Mediana")){
            mediana();
            System.out.println("Seleccionaste Mediana");
        } 
        if (e.getActionCommand().equals("Maximo")){
            maximo();
            System.out.println("Seleccionaste Maximo");
        }
        if (e.getActionCommand().equals("Minimo")){
            minimo();
            System.out.println("Seleccionaste Minimo");
        }
        if (e.getActionCommand().equals("Medio")){
            medio();
            System.out.println("Seleccionaste Medio");
        } 
        if (e.getActionCommand().equals("Media Adaptativa")){
            mediaAdaptativa();
            System.out.println("Seleccionaste Media adaptativa");
        }
        if (e.getActionCommand().equals("Transformar")){
            transformar();
            System.out.println("Seleccionaste transformar");
        }
        if (e.getActionCommand().equals("Ver Espectro")){
            verEspectro();
            System.out.println("Seleccionaste ver espectro");
        }    
        if (e.getActionCommand().equals("Ideal low pass filter")){
            String ILPS = JOptionPane.showInputDialog("Ingrese el valor de radio:");
            Double radio = Double.valueOf(ILPS);
            ILPF(radio);
            System.out.println(radio);
        } 
        if (e.getActionCommand().equals("Butterworth low pass filter")){
            String BLPS = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Orden = JOptionPane.showInputDialog("Ingrese el valor de orden:");
            Double radio = Double.parseDouble(BLPS);
            int orden = Integer.parseInt(Orden);
            BLPS(orden, radio);
        }
        if (e.getActionCommand().equals("Ideal high pass filter")){
            String IHPS = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            Double radio = Double.parseDouble(IHPS);
            IHPS(radio);
        }    
        if (e.getActionCommand().equals("Butterworth high pass filter")){
            String BHPS = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Orden = JOptionPane.showInputDialog("Ingrese el valor de orden");
            Double radio = Double.parseDouble(BHPS);
            int orden = Integer.parseInt(Orden);
            BHPS(orden, radio);
        }  
        if (e.getActionCommand().equals("Ideal Band Pass Filter")){
            String IBPF = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Orden = JOptionPane.showInputDialog("Ingrese el valor de delta");
            Double radio = Double.parseDouble(IBPF);
            Double delta = Double.parseDouble(Orden);
            IBPF(delta, radio);
        }      
        if (e.getActionCommand().equals("Ideal Band Stop Filter")){
            String IBPF = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Delta = JOptionPane.showInputDialog("Ingrese el valor de delta");
            Double radio = Double.parseDouble(IBPF);
            Double delta = Double.parseDouble(Delta);
            IBSF(delta, radio);
        }    
        if (e.getActionCommand().equals("Butterworth Band Pass Filter")){
            String BLPS = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Orden = JOptionPane.showInputDialog("Ingrese el valor de orden:");
            Double radio = Double.parseDouble(BLPS);
            Double delta = Double.parseDouble(Orden);
            BBPF(delta, radio);
        }  
        if (e.getActionCommand().equals("Butterworth Band Stop Filter")){
            String IBPF = JOptionPane.showInputDialog("Ingrese el valor del radio:");
            String Delta = JOptionPane.showInputDialog("Ingrese el valor de delta:");
            Double radio = Double.parseDouble(IBPF);
            Double delta = Double.parseDouble(Delta);
            BBSF(delta, radio);
        }    
        if (e.getActionCommand().equals("Calcular Histograma")){
            calcularHistograma();
        }           
        if (e.getActionCommand().equals("Ver Histograma")){
            VerHistograma();
        }  
        if (e.getActionCommand().equals("RGB a CMY")){
            RGBtoCMY();
            System.out.println("RGB to CMY");
        }    
        if (e.getActionCommand().equals("CMY a RGB")){
            System.out.println("CMY to RGB");
            CMYtoRGB();
        } 
        if (e.getActionCommand().equals("RGB a HSI")){
            RGBtoHSI();
            System.out.println("RGB to HSI");
        }          
        if (e.getActionCommand().equals("Dilatacion")){
            dilatacion();
            System.out.println("Seleccionaste dilatacion");
        }  
        if (e.getActionCommand().equals("Erosión")){
            erosion();
            System.out.println("Seleccionaste erosion");
        }   
        if (e.getActionCommand().equals("Apertura")){
            apertura();
            System.out.println("Seleccionaste Apertura");
        } 
        if (e.getActionCommand().equals("Cierre")){
            cierre();
            System.out.println("Seleccionaste erosion");
        }     
        if (e.getActionCommand().equals("Guardar imagen")){
            guardar();
            System.out.println("Se está guardando la imagen");
        }
        if (e.getActionCommand().equals("Creditos")){
            JOptionPane.showMessageDialog(null, "Proyecto creado por: Joshtin Yael Cortes López");
            System.out.println("Se estan mostrando los creditos");
        }   
    }
    
    private void abrirArchivoImagen(){
        objImagenProcesada = null;
        JFileChooser selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg","jpeg");
        selectorArchivos.setFileFilter(filtro);
        int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
        if(respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()){
            archivoImagen = selectorArchivos.getSelectedFile();
            objImagenFuente = new Imagen(archivoImagen);
            System.out.println(objImagenFuente.getFilas());
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenFuente.getBufferImagen()));
            panelPropiedades= new PanelPropiedades(); 
            objVentanaPrincipal.jPanel3.removeAll();
            objVentanaPrincipal.jPanel3.setLayout(new BorderLayout());
            objVentanaPrincipal.jPanel3.add(panelPropiedades, BorderLayout.CENTER);
            panelPropiedades.Dir.setText(archivoImagen.getName());
            panelPropiedades.For.setText(objImagenFuente.getFormato());
            panelPropiedades.Alt.setText(String.valueOf(objImagenFuente.getFilas()));
            panelPropiedades.Anch.setText(String.valueOf(objImagenFuente.getColumnas()));
        }
    } 
    
    private void guardar() {
    JFileChooser fileChooser = new JFileChooser();

    int resultado = fileChooser.showSaveDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        
        File archivoSeleccionado = fileChooser.getSelectedFile();

        String nombreArchivo = archivoSeleccionado.getName();
        if (!nombreArchivo.toLowerCase().endsWith(".png")) {
            archivoSeleccionado = new File(archivoSeleccionado.getParentFile(), nombreArchivo + ".png");
        }
        try {
            ImageIO.write(objImagenProcesada.getBufferImagen(), "png", archivoSeleccionado);
            JOptionPane.showMessageDialog(null, "Imagen guardada exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    private void convertirEscalaGrises(){
        if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
        } 
        if(objImagenProcesada == null){
        objImagenProcesada = objImagenFuente.clone();
        }
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(objImagenProcesada.getMatrizGris()));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        JOptionPane.showMessageDialog(null, "Despues de presionar esta opción una vez no es necesario volver a hacerlo aunque vuelvas a la imagen original");
    }
    
    private void rotar90Grados() {
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizRotada = operaciones.rotar90Grados(matrizGris);
        objImagenProcesada.setMatrizGris(matrizRotada);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRotada));

        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    
    private void rotar180Grados() {
    errorCarga();
    Operaciones operaciones = new Operaciones();
    short[][] matrizGris = objImagenProcesada.getMatrizGris();
    short[][] matrizRotada = operaciones.rotar180Grados(matrizGris);
    objImagenProcesada.setMatrizGris(matrizRotada);
    objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRotada));

    objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
}
     
    
    private void rotar270Grados() {
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizRotada = operaciones.rotar270Grados(matrizGris);
        objImagenProcesada.setMatrizGris(matrizRotada);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRotada));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    } 
    
    private void trasladar(int desplazamiento) {
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizTraslacion = operaciones.trasladar(matrizGris, desplazamiento);
        objImagenProcesada.setMatrizGris(matrizTraslacion);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizTraslacion));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

   
    private void sumarEscalar(int brillo){
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizSuma = operaciones.SumarEscalar(matrizGris, brillo);
        objImagenProcesada.setMatrizGris(matrizSuma);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizSuma));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void restarEscalar(int oscuro){
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizSuma = operaciones.RestaEscalar(matrizGris, oscuro);
        objImagenProcesada.setMatrizGris(matrizSuma);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizSuma));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void reflexionY(){
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizRef = operaciones.reflejarEnY(matrizGris);
        objImagenProcesada.setMatrizGris(matrizRef);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRef));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        
    }
    
    private void reflexionX(){
        errorCarga();
        Operaciones operaciones = new Operaciones();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizRef = operaciones.reflejarEnX(matrizGris);
        objImagenProcesada.setMatrizGris(matrizRef);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRef));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }

    
   private void suma() {
    if(objImagenFuente == null){
        JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
    }else if (objImagenProcesada == null){
        JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
    }else{    
    JFileChooser selectorArchivos = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg", "jpeg");
    selectorArchivos.setFileFilter(filtro);
    
    int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
    if (respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()) {
        File archivoImagen2 = selectorArchivos.getSelectedFile();
        Imagen imagen2 = new Imagen(archivoImagen2);
        objImagenProcesada = objImagenFuente.clone();
        if(objImagenProcesada.getMatrizGris().length != imagen2.getMatrizGris().length){
        JOptionPane.showMessageDialog(null, "La segunda imagen debe ser del mismo tamaño que la primera");    
        }else{
        short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
        short[][] matrizGris2 = imagen2.getMatrizGris();
        
        Operaciones operaciones = new Operaciones();
        short[][] matrizResultado = operaciones.suma(matrizGris1, matrizGris2);
        objImagenProcesada.setMatrizGris(matrizResultado);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }
    }
    }
    }

 private void resta() {
    if(objImagenFuente == null){
        JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
    }else if (objImagenProcesada == null){
        JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
    }else{
    JFileChooser selectorArchivos = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg", "jpeg");
    selectorArchivos.setFileFilter(filtro);
    
    int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
    if (respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()) {
        File archivoImagen2 = selectorArchivos.getSelectedFile();
        Imagen imagen2 = new Imagen(archivoImagen2);
        objImagenProcesada = objImagenFuente.clone();
        if(objImagenProcesada.getMatrizGris().length != imagen2.getMatrizGris().length){
        JOptionPane.showMessageDialog(null, "La segunda imagen debe ser del mismo tamaño que la primera");    
        }else{
        short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
        short[][] matrizGris2 = imagen2.getMatrizGris();
        
        Operaciones operaciones = new Operaciones();
        short[][] matrizResultado = operaciones.resta(matrizGris1, matrizGris2);
        objImagenProcesada.setMatrizGris(matrizResultado);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }
    }
    }
    }
 
     private void AND(){
        if(objImagenFuente == null){
            JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
        }else if (objImagenProcesada == null){
            JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
        }else{
        JFileChooser selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg", "jpeg");
        selectorArchivos.setFileFilter(filtro);
    
        int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()) {
            File archivoImagen2 = selectorArchivos.getSelectedFile();
            Imagen imagen2 = new Imagen(archivoImagen2);
        
            short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
            short[][] matrizGris2 = imagen2.getMatrizGris();
        
            Operaciones operaciones = new Operaciones();
            short[][] matrizResultado = operaciones.AND(matrizGris1, matrizGris2);
            objImagenProcesada.setMatrizGris(matrizResultado);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }
        }
    }

    private void OR(){
        if(objImagenFuente == null){
            JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
        }else if (objImagenProcesada == null){
            JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
        }else{        
        JFileChooser selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg", "jpeg");
        selectorArchivos.setFileFilter(filtro);
    
        int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()) {
            File archivoImagen2 = selectorArchivos.getSelectedFile();
            Imagen imagen2 = new Imagen(archivoImagen2);
        
            short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
            short[][] matrizGris2 = imagen2.getMatrizGris();
        
            Operaciones operaciones = new Operaciones();
            short[][] matrizResultado = operaciones.OR(matrizGris1, matrizGris2);
            objImagenProcesada.setMatrizGris(matrizResultado);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }
    }
    }
        
    private void NOT(){
    if(objImagenFuente == null){
        JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
    }else if (objImagenProcesada == null){
        JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
    }else{
            short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
        
            Operaciones operaciones = new Operaciones();
            short[][] matrizResultado = operaciones.NOT(matrizGris1);
            objImagenProcesada.setMatrizGris(matrizResultado);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }    
    }
    
    private void XOR(){
    if(objImagenFuente == null){
        JOptionPane.showMessageDialog(null, "Debes abrir una imagen primero");
    }else if (objImagenProcesada == null){
        JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises");
    }else{
        JFileChooser selectorArchivos = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPEG FILE", "jpg", "jpeg");
        selectorArchivos.setFileFilter(filtro);
    
        int respuesta = selectorArchivos.showOpenDialog(objVentanaPrincipal);
        if (respuesta == JFileChooser.APPROVE_OPTION && selectorArchivos.getSelectedFile().exists()) {
            File archivoImagen2 = selectorArchivos.getSelectedFile();
            Imagen imagen2 = new Imagen(archivoImagen2);
        
            short[][] matrizGris1 = objImagenProcesada.getMatrizGris();
            short[][] matrizGris2 = imagen2.getMatrizGris();
        
            Operaciones operaciones = new Operaciones();
            short[][] matrizResultado = operaciones.XOR(matrizGris1, matrizGris2);
            objImagenProcesada.setMatrizGris(matrizResultado);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizResultado));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        }
    }
    }

    private void negativo() {
        errorCarga();
        System.out.println("Se esta aplicando el algoritmo");
        Umbralizacion umbralizacion = new Umbralizacion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizNega = umbralizacion.inverso(matrizGris);
        objImagenProcesada.setMatrizGris(matrizNega);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizNega));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");
    }
    
    private void umbral(){
        errorCarga();
        try {
            String valor = objUmbralizacion.jTexto1.getText();
            int valo = Integer.parseInt(valor);
            Umbralizacion umbralizacion = new Umbralizacion();
            short[][] matrizGris = objImagenProcesada.getMatrizGris();
            short[][] matrizUm = umbralizacion.umbral(matrizGris, valo);
            objImagenProcesada.setMatrizGris(matrizUm);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizUm));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));            
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar un valor de umbral");
        }
    }
    
    private void umbralInv(){
        errorCarga();
        try {
            String valor = objUmbralizacion.jTexto1.getText();
            int valo = Integer.parseInt(valor);
            Umbralizacion umbralizacion = new Umbralizacion();
            short[][] matrizGris = objImagenProcesada.getMatrizGris();
            short[][] matrizUm = umbralizacion.umbralin(matrizGris, valo);
            objImagenProcesada.setMatrizGris(matrizUm);
            objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizUm));
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));            
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar un valor de umbral");
        }

    }
    
    private void intUmbral(){
        errorCarga();
         try {
            String valor = objUmbralizacion.jTexto1.getText();
        int valo = Integer.parseInt(valor);
        String valor2 = objUmbralizacion.jTexto1.getText();
        int valo2 = Integer.parseInt(valor2);
        Umbralizacion umbralizacion = new Umbralizacion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizIntUm = umbralizacion.intervaloUmbral001(matrizGris, valo, valo2);
        objImagenProcesada.setMatrizGris(matrizIntUm);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizIntUm));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));          
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar ambos valores del intervalo del umbral");
        }
    }
    
    private void intUmbralIn(){
        errorCarga();
        try {
            String valor = objUmbralizacion.jTexto1.getText();
        int valo = Integer.parseInt(valor);
        String valor2 = objUmbralizacion.jTexto1.getText();
        int valo2 = Integer.parseInt(valor2);
        Umbralizacion umbralizacion = new Umbralizacion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizIntUm = umbralizacion.intervaloUmbralin001(matrizGris, valo, valo2);
        objImagenProcesada.setMatrizGris(matrizIntUm);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizIntUm));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));          
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar ambos valores del intervalo del umbral");
        }
    }
    
    private void intUmbralG(){
        errorCarga();
        try {
            String valor = objUmbralizacion.jTexto1.getText();
        int valo = Integer.parseInt(valor);
        String valor2 = objUmbralizacion.jTexto1.getText();
        int valo2 = Integer.parseInt(valor2);
        Umbralizacion umbralizacion = new Umbralizacion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizIntUm = umbralizacion.intervaloUmbralGris(matrizGris, valo, valo2);
        objImagenProcesada.setMatrizGris(matrizIntUm);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizIntUm));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));          
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar ambos valores del intervalo del umbral");
        }
    }

    private void intUmbralGI(){
        errorCarga();
        try {
            String valor = objUmbralizacion.jTexto1.getText();
        int valo = Integer.parseInt(valor);
        String valor2 = objUmbralizacion.jTexto1.getText();
        int valo2 = Integer.parseInt(valor2);
        Umbralizacion umbralizacion = new Umbralizacion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizIntUm = umbralizacion.intervaloUmbralGrisIn(matrizGris, valo, valo2);
        objImagenProcesada.setMatrizGris(matrizIntUm);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizIntUm));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));          
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar ambos valores del intervalo del umbral");
        }
    }
    
    private void convolucion(){
        errorCarga();
        try {
        String valor1 = objConvolucion.posicion1.getText();
        String valor2 = objConvolucion.posicion2.getText();
        String valor3 = objConvolucion.posicion3.getText();
        String valor4 = objConvolucion.posicion4.getText();
        String valor5 = objConvolucion.posicion5.getText();
        String valor6 = objConvolucion.posicion6.getText();
        String valor7 = objConvolucion.posicion7.getText();
        String valor8 = objConvolucion.posicion8.getText();
        String valor9 = objConvolucion.posicion9.getText(); 
        
        short val1 = (short) Integer.parseInt(valor1);
        short val2 = (short) Integer.parseInt(valor2);
        short val3 = (short) Integer.parseInt(valor3);
        short val4 = (short) Integer.parseInt(valor4);
        short val5 = (short) Integer.parseInt(valor5);
        short val6 = (short) Integer.parseInt(valor6);
        short val7 = (short) Integer.parseInt(valor7);
        short val8 = (short) Integer.parseInt(valor8);
        short val9 = (short) Integer.parseInt(valor9);   
        Convolucion convolucion = new Convolucion();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizIntUm = convolucion.convolucion(matrizGris, val1, val2, val3, val4, val5, val6, val7, val8, val9);
        objImagenProcesada.setMatrizGris(matrizIntUm);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizIntUm));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Debes colocar todos los valores de la matriz");
        }
    }  
    
    private void mediaAritmetica(){
        errorCarga();
        Ruido ruido = new Ruido();
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMediaAritmetica(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");    
    }
    
    private void mediaGeometrica(){
        errorCarga();
        Ruido ruido = new Ruido();
        short[][] matrizRgb = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMediaGeometrica(matrizRgb);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");    
    } 

    private void contraArmonica(){
        errorCarga();
        Ruido ruido = new Ruido();
        String valor1 = objContraarmonica.jTextValor.getText();
        System.out.println(valor1);
        double val1 = Double.parseDouble(valor1);
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroContraArmonica(matrizGris, val1);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");       
    }

    private void mediana(){
        errorCarga();
        Ruido ruido = new Ruido();        
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMediana(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");         
    }

    private void maximo(){
        errorCarga();
        Ruido ruido = new Ruido();        
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMaximo(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");         
    }
    
    private void minimo(){
        errorCarga();
        Ruido ruido = new Ruido();        
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMinimo(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");         
    }
    
    private void medio(){
        errorCarga();
        Ruido ruido = new Ruido();        
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMedio(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");         
    }      
    
    private void mediaAdaptativa(){
        errorCarga();
        Ruido ruido = new Ruido();        
        short[][] matrizGris = objImagenProcesada.getMatrizGris();
        short[][] matrizAri = ruido.filtroMediaAdaptativa(matrizGris);
        objImagenProcesada.setMatrizGris(matrizAri);
        objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizAri));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se esta aplicando el algoritmo");         
    } 
    
    private void transformar() {
        if (objImagenProcesada == null){
        objImagenProcesada = objImagenFuente.clone();
        }
        errorCarga();
        try {
            ImageFFT imageFFT = new ImageFFT(objImagenProcesada.getBufferImagen());
            imageFFT.transform();
            transformedImage = imageFFT;
            System.out.println("Se ha transformado la imagen");
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int contadorVerEspectro = 0;
    
    private void verEspectro() {
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir el botón transformar");
            return;
        }
           
    try {
        objImagenProcesada.setBufferImagen(transformedImage.getSpectrum());
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
        System.out.println("Se ha mostrado el espectro en la interfaz");
        contadorVerEspectro ++;
    } catch (FFTException ex) {
        Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void ILPF(Double radio) {
        Double regla3 = ((radio * 1) / 360);
        System.out.println(regla3); 
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            transformedImage.idealLowPassFilter(regla3);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    private void BLPS(int orden, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            System.out.println(regla3);             
            transformedImage.butterworthLowPassFilter(orden,regla3);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void IHPS(Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            System.out.println(regla3);             
            transformedImage.idealHighPassFilter(regla3);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void BHPS(int orden, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            System.out.println(regla3);             
            transformedImage.butterworthHighPassFilter(orden,regla3);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void IBPF(Double delta, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            Double regladel = ((delta * 1)/ 360);
            System.out.println(regla3);             
            transformedImage.idealBandPassFilter(regla3, regladel);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void IBSF(Double delta, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            System.out.println(regla3);  
            Double regladel = ((delta * 1)/ 360);
            transformedImage.idealBandStopFilter(regla3,regladel);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      

    private void BBPF(Double delta, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            Double regladel = ((delta * 1)/ 360);
            System.out.println(regla3);             
            transformedImage.butterworthBandPassFilter(regla3,regladel);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void BBSF(Double delta, Double radio){
        if (transformedImage == null) {
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
            return;
        } else if (contadorVerEspectro == 0){
            JOptionPane.showMessageDialog(null, "Debes oprimir transformar y luego ver espectro");
        }
        try {
            Double regla3 = ((radio * 1) / 360);
            Double regladel = ((delta * 1)/ 360);
            System.out.println(regla3);             
            transformedImage.butterworthBandStopFilter(regla3, regladel);
            transformedImage.transform();
            BufferedImage bf = transformedImage.toImage(objImagenProcesada.getBufferImagen());
            objImagenProcesada.setBufferImagen(bf);
            objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(bf));
            System.out.println("Se ha mostrado el espectro en la interfaz");
            contadorVerEspectro = 0;
        } catch (FFTException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
    
    Histogram h = new Histogram();
    int contadorCH = 0;
    private void calcularHistograma(){
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       } else if(objImagenProcesada == null){
            objImagenProcesada = objImagenFuente.clone();
       }
        try {
            h.computeHistogram(objImagenProcesada.getBufferImagen());
            System.out.println(h.getNumBands());
            contadorCH ++;
        } catch (HistogramException ex) {
            Logger.getLogger(ControladorAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    private void VerHistograma(){
        if(objImagenFuente == null){
            JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
        }else if(contadorCH == 0){
            JOptionPane.showMessageDialog(null, "Debes presionar calcular histograma");
        }
            HistogramTool histogramTool = new HistogramTool(h, "imagen");
            histogramTool.setSize(300, 250);
            histogramTool.setVisible(true);  
            contadorCH = 0;     
    }
    
    private void RGBtoCMY(){
        if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();  
       }
        short[][] R = objImagenProcesada.getMatrizR();
        short[][] G = objImagenProcesada.getMatrizG();
        short[][] B = objImagenProcesada.getMatrizB();
        objImagenProcesada.setBufferImagen(objImagenProcesada.RGBtoCMY(R, G, B));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    private void CMYtoRGB(){
        if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone(); 
       }
        short[][] C = objImagenProcesada.getMatrizR();
        short[][] M = objImagenProcesada.getMatrizG();
        short[][] Y = objImagenProcesada.getMatrizB();
        objImagenProcesada.CMYtoRGB(C, M, Y);
        objImagenProcesada.setBufferImagen(objImagenProcesada.CMYtoRGB(C, M, Y));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));      
    }
    private void RGBtoHSI(){
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();         
       }
        short[][] R = objImagenProcesada.getMatrizR();
        short[][] G = objImagenProcesada.getMatrizG();
        short[][] B = objImagenProcesada.getMatrizB();
        objImagenProcesada.setBufferImagen(objImagenProcesada.RGBtoHSI(R, G, B));
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
    private void dilatacion(){
        if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();         
       }  
       Morfologicas m = new Morfologicas();
       short[][] matrizGris = objImagenProcesada.getMatrizGris();
       short[][] circulo = {
        {0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0},
       };
        short [][] matrizRes = m.dilatacion(matrizGris, circulo);
        objImagenProcesada.setMatrizGris(matrizRes);
       objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRes));
       objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
       System.out.println("Se esta aplicando el algoritmo");
    }
        
    private void erosion(){
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();         
       }
       Morfologicas m = new Morfologicas();
       short[][] matrizGris = objImagenProcesada.getMatrizGris();
       short[][] circulo = {
        {0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0},
       };
        short [][] matrizRes = m.erosion(matrizGris, circulo);
        objImagenProcesada.setMatrizGris(matrizRes);
       objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRes));
       objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
       System.out.println("Se esta aplicando el algoritmo");
    }
    private void apertura(){
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();         
       }       
        Morfologicas m = new Morfologicas();
       short[][] matrizGris = objImagenProcesada.getMatrizGris();
       short[][] circulo = {
        {0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0},
       };
        short [][] matrizRes = m.dilatacion(matrizGris, circulo);
        matrizRes = m.erosion(matrizRes, circulo);
        objImagenProcesada.setMatrizGris(matrizRes);
       objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRes));
       objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
       System.out.println("Se esta aplicando el algoritmo");
       
    }
    private void cierre(){
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }else if( objImagenProcesada == null){
         objImagenProcesada = objImagenFuente.clone();         
       }     
       Morfologicas m = new Morfologicas();
       objImagenProcesada = objImagenFuente.clone();
       short[][] matrizGris = objImagenProcesada.getMatrizGris();
       short[][] circulo = {
        {0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0},
       };
        short [][] matrizRes = m.erosion(matrizGris, circulo);
        matrizRes = m.dilatacion(matrizRes, circulo);
        objImagenProcesada.setMatrizGris(matrizRes);
       objImagenProcesada.setBufferImagen(objImagenProcesada.convierteMatrizEnBuffered(matrizRes));
       objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
       System.out.println("Se esta aplicando el algoritmo");
    }
        
    private void mostrarImagenOriginal() {
        if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       }
        objImagenProcesada = null;
        objImagenProcesada = objImagenFuente.clone();
        Imagen imagen = new Imagen();
        objVentanaPrincipal.labelImagen.setIcon(new ImageIcon(objImagenProcesada.getBufferImagen()));
    }
    
   private void errorCarga(){
        //Error imagen sin cargar
       if(objImagenFuente == null){
           JOptionPane.showMessageDialog(null, "Debes cargar la imagen primero");
       } else if (objImagenProcesada == null){
           JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises primero");    
       } else if (objImagenProcesada.getMatrizGris() == null){
           JOptionPane.showMessageDialog(null, "Debes convertir la imagen a escala de grises primero");    
       }   
    }
}