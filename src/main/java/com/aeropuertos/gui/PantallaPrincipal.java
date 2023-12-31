package com.aeropuertos.gui;

import com.aeropuertos.dto.Aeropuerto;
import com.aeropuertos.logica.LogicaNegocio;
import com.aeropuertos.persistencia.Persistencia;
import componentes.clases.base.ImagenFondo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 34675
 */
public class PantallaPrincipal extends javax.swing.JFrame {
   private JFrame ayuda;
   private JFXPanel jFXPanel;
   private Aeropuerto aeropuertoBase;
   private List<Aeropuerto> listaAeropuertosNoBase=new ArrayList<>();
   private List<Aeropuerto> listaOriginal;
    public PantallaPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        initComponents();
        listaOriginal=LogicaNegocio.getListaAeropuertosOriginal();
        if(!listaOriginal.isEmpty()){
            DefaultComboBoxModel<Aeropuerto> modelo=new DefaultComboBoxModel<Aeropuerto>();
            modelo.addAll(LogicaNegocio.getListaAeropuertosOriginal());
            comboBoxAeropuertos.setModel(modelo);
            comboBoxAeropuertos.setSelectedIndex(1);
        }else{
           btnSeleccionar.setEnabled(false); 
        }
        mnuCompania.setEnabled(false);
        mnuVuelosBase.setEnabled(false);
        mnuVuelosDiarios.setEnabled(false);
        mnuConsultas.setEnabled(false);
        mnuAyuda.setEnabled(false);
        this.setTitle("GESTION AEROPURTO");
        rbtAyudaContex.setVisible(false);
        btnAyudaComp.setVisible(false);
        btnAyudaVB.setVisible(false);
        btnAyudaVD.setVisible(false);
        setHelp();
        if(listaOriginal.isEmpty())JOptionPane.showMessageDialog(this, "Fichero de Aeropuerto no existe,o esta vacio","ERROR LECTURA FICHERO", JOptionPane.ERROR_MESSAGE);
    }
    private void setHelp(){
        //instanciamos el frame con el jfxpanel que va a recibir nuestra HTML de ayuda
        ayuda=new JFrame("AYUDA");
        jFXPanel = new JFXPanel();
        ayuda.setSize(new Dimension(700, 700));
        ayuda.add(jFXPanel);
        asociarAcionInputMap();
        
    }
  
    
    private void asociarAcionInputMap(){
         Map<JComponent,String> mapaAyuda=new HashMap<>();
        mapaAyuda.put(btnAyudaComp, "https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-companias");
        mapaAyuda.put(btnAyudaVB, "https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-vuelo-base");
        mapaAyuda.put(btnAyudaVD, "https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-vuelos-diarios");
        //recorre el mapa medinte su clave y para cada clave se asigna un ebvento y sua accion 
        for (JComponent comp : mapaAyuda.keySet()) {
            KeyStroke f1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);//declara evento para f1
            InputMap inputMap = comp.getInputMap(JComponent.WHEN_FOCUSED);//recupera el mapa del componente cuando tenga el foco
            ActionMap actionMap = comp.getActionMap();//recupera el mapa de acciones del componente
            inputMap.put(f1KeyStroke, "showContextualHelp");//asocia inputmap con el action mapa clave valo
            actionMap.put("showContextualHelp", new AbstractAction() {//asocia action map a lo que va a lanzar 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tiene el foco"+comp.getName());
            String helpURL;
            helpURL = mapaAyuda.get(comp);//recupeara la url asociada al componente cuando de lanza el evento
            openWebView(helpURL);
            }
           });
        }
    }
    private void openWebView(String url) {
         Platform.runLater(() -> {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);
        jFXPanel.setScene(new Scene(webView));
        ayuda.setVisible(true);
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxAeropuertos = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();
        lblSelect = new javax.swing.JLabel();
        rbtAyudaContex = new javax.swing.JRadioButton();
        btnAyudaComp = new javax.swing.JButton();
        btnAyudaVB = new javax.swing.JButton();
        btnAyudaVD = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCompania = new javax.swing.JMenu();
        mnuCrearCmp = new javax.swing.JMenuItem();
        mnuEliminarCmp = new javax.swing.JMenuItem();
        mnuModificarCmp = new javax.swing.JMenuItem();
        mnuConsultarCmp = new javax.swing.JMenuItem();
        mnuVuelosBase = new javax.swing.JMenu();
        mnuCrearVuelo = new javax.swing.JMenuItem();
        mnuEliminarVuelo = new javax.swing.JMenuItem();
        mnuModificarVuelo = new javax.swing.JMenuItem();
        mnuConsultarVuelo = new javax.swing.JMenuItem();
        mnuVuelosDiarios = new javax.swing.JMenu();
        mnuAltaVueloDiario = new javax.swing.JMenuItem();
        mnuEliminarVD = new javax.swing.JMenuItem();
        mnuModificarVDiario = new javax.swing.JMenuItem();
        mnuConsultarVDiario = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuSalidas = new javax.swing.JMenuItem();
        mnuVuelosCompania = new javax.swing.JMenuItem();
        mnuVuelosDestinos = new javax.swing.JMenuItem();
        mnuRecaudacion = new javax.swing.JMenuItem();
        mnuClima = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaSobre = new javax.swing.JMenuItem();
        mnuAyudaCompani = new javax.swing.JMenuItem();
        mnuAyudaVueloBase = new javax.swing.JMenuItem();
        mnuAyudaVueloDiario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(620, 410));
        setSize(new java.awt.Dimension(610, 420));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        comboBoxAeropuertos.setToolTipText("");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblSelect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSelect.setText("ESCOGA AEROPUERTO BASE PARA SU APLICACION");

        rbtAyudaContex.setText("Activar Ayuda Contextual");
        rbtAyudaContex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAyudaContexActionPerformed(evt);
            }
        });

        btnAyudaComp.setText("Ayuda Compañias");

        btnAyudaVB.setText("Ayuda Vuelos Base");

        btnAyudaVD.setText("Ayuda Vuelos Diarios");

        mnuCompania.setText("Compañias");

        mnuCrearCmp.setText("Crear");
        mnuCrearCmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearCmpActionPerformed(evt);
            }
        });
        mnuCompania.add(mnuCrearCmp);

        mnuEliminarCmp.setText("Eliminar");
        mnuEliminarCmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarCmpActionPerformed(evt);
            }
        });
        mnuCompania.add(mnuEliminarCmp);

        mnuModificarCmp.setText("Modificar");
        mnuModificarCmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarCmpActionPerformed(evt);
            }
        });
        mnuCompania.add(mnuModificarCmp);

        mnuConsultarCmp.setText("Consultar");
        mnuConsultarCmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarCmpActionPerformed(evt);
            }
        });
        mnuCompania.add(mnuConsultarCmp);

        jMenuBar1.add(mnuCompania);

        mnuVuelosBase.setText("Vuelo Base");

        mnuCrearVuelo.setText("Cear");
        mnuCrearVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearVueloActionPerformed(evt);
            }
        });
        mnuVuelosBase.add(mnuCrearVuelo);

        mnuEliminarVuelo.setText("Eliminar");
        mnuEliminarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarVueloActionPerformed(evt);
            }
        });
        mnuVuelosBase.add(mnuEliminarVuelo);

        mnuModificarVuelo.setText("Modificar");
        mnuModificarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarVueloActionPerformed(evt);
            }
        });
        mnuVuelosBase.add(mnuModificarVuelo);

        mnuConsultarVuelo.setText("Consultar");
        mnuConsultarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarVueloActionPerformed(evt);
            }
        });
        mnuVuelosBase.add(mnuConsultarVuelo);

        jMenuBar1.add(mnuVuelosBase);

        mnuVuelosDiarios.setText("Vuelos Diarios");

        mnuAltaVueloDiario.setText("Crear");
        mnuAltaVueloDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltaVueloDiarioActionPerformed(evt);
            }
        });
        mnuVuelosDiarios.add(mnuAltaVueloDiario);

        mnuEliminarVD.setText("Eliminar");
        mnuEliminarVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarVDActionPerformed(evt);
            }
        });
        mnuVuelosDiarios.add(mnuEliminarVD);

        mnuModificarVDiario.setText("Modificar");
        mnuModificarVDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarVDiarioActionPerformed(evt);
            }
        });
        mnuVuelosDiarios.add(mnuModificarVDiario);

        mnuConsultarVDiario.setText("Consultar");
        mnuConsultarVDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarVDiarioActionPerformed(evt);
            }
        });
        mnuVuelosDiarios.add(mnuConsultarVDiario);

        jMenuBar1.add(mnuVuelosDiarios);

        mnuConsultas.setText("Consultas");

        mnuSalidas.setText("Vuelos Salida/Llegada");
        mnuSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalidasActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuSalidas);

        mnuVuelosCompania.setText("Vuelos por Compañia");
        mnuVuelosCompania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVuelosCompaniaActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuVuelosCompania);

        mnuVuelosDestinos.setText("Vuelos por Destino");
        mnuVuelosDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVuelosDestinosActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuVuelosDestinos);

        mnuRecaudacion.setText("Recaudacion");
        mnuRecaudacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecaudacionActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuRecaudacion);

        mnuClima.setText("Datos Climatologicos");
        mnuClima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClimaActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnuClima);

        jMenuBar1.add(mnuConsultas);

        mnuAyuda.setText("Ayuda");

        mnuAyudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuAyudaSobre.setText("Ayuda Principal");
        mnuAyudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaSobreActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaSobre);

        mnuAyudaCompani.setText("Ayuda Compañias");
        mnuAyudaCompani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaCompaniActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaCompani);

        mnuAyudaVueloBase.setText("Ayuda Vuelos Base");
        mnuAyudaVueloBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaVueloBaseActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaVueloBase);

        mnuAyudaVueloDiario.setText("Ayuda Vuelos Diarios");
        mnuAyudaVueloDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaVueloDiarioActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaVueloDiario);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxAeropuertos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAyudaComp)
                                    .addComponent(rbtAyudaContex)
                                    .addComponent(btnAyudaVB)
                                    .addComponent(btnAyudaVD))))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxAeropuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(rbtAyudaContex)
                .addGap(18, 18, 18)
                .addComponent(btnAyudaComp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAyudaVB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAyudaVD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCrearCmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearCmpActionPerformed
 //crear un dialogo de insertar compañias
      DarAltaCompania darAltaCompania=new DarAltaCompania(new JDialog(), true);
      darAltaCompania.setVisible(true);
    }//GEN-LAST:event_mnuCrearCmpActionPerformed

    private void mnuModificarCmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarCmpActionPerformed
      ModificarCompaniaAerea modificar=new ModificarCompaniaAerea(this, true);
      modificar.setVisible(true);
    }//GEN-LAST:event_mnuModificarCmpActionPerformed

    private void mnuConsultarCmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarCmpActionPerformed
      ConsultarCompaniasAereas consultarCompaniasAereas=new ConsultarCompaniasAereas(this, true);
      consultarCompaniasAereas.setVisible(true);
    }//GEN-LAST:event_mnuConsultarCmpActionPerformed

    private void mnuCrearVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearVueloActionPerformed
     DarAltaVuelosBase darAltaVuelosBase=new DarAltaVuelosBase(this, true);
     darAltaVuelosBase.setVisible(true);
    }//GEN-LAST:event_mnuCrearVueloActionPerformed

    private void mnuConsultarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarVueloActionPerformed
      ConsultarVuelosBase vuelosBase=new ConsultarVuelosBase(new JDialog(), true);
      vuelosBase.setVisible(true);
    }//GEN-LAST:event_mnuConsultarVueloActionPerformed

    private void mnuEliminarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarVueloActionPerformed
   DarBajaVueloBase bajaVueloBase=new DarBajaVueloBase(this, true);
   bajaVueloBase.setVisible(true);
    }//GEN-LAST:event_mnuEliminarVueloActionPerformed

    private void mnuEliminarCmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarCmpActionPerformed
       DarBajaCompania darBajaCompania=new DarBajaCompania(this, true);
       darBajaCompania.setVisible(true);
    }//GEN-LAST:event_mnuEliminarCmpActionPerformed

    private void mnuModificarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarVueloActionPerformed
        ModificarVueloBase modificarVueloBase=new ModificarVueloBase(this, true);
        modificarVueloBase.setVisible(true);
        
    }//GEN-LAST:event_mnuModificarVueloActionPerformed

    private void mnuAltaVueloDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltaVueloDiarioActionPerformed
        DarAltaVueloDiario darAltaVueloDiario=new DarAltaVueloDiario(this, true);
        darAltaVueloDiario.setVisible(true);
    }//GEN-LAST:event_mnuAltaVueloDiarioActionPerformed

    private void mnuEliminarVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarVDActionPerformed
        DarBajaVueloDiario darBajaVueloDiario=new DarBajaVueloDiario(this, true);
        darBajaVueloDiario.setVisible(true);
    }//GEN-LAST:event_mnuEliminarVDActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
       //recupero el aeropuerto seleccionado
        aeropuertoBase=(Aeropuerto)comboBoxAeropuertos.getSelectedItem();
        //pregunta si el aeropuerto elegigo es el correcto
        int opcion=JOptionPane.showConfirmDialog(this,("Su aeropuerto base sera "+aeropuertoBase.getNombre()),
                "AEROPUERTO BASE", JOptionPane.YES_NO_OPTION);
        if (opcion==0){
            LogicaNegocio.setAeropuertoBase(aeropuertoBase);
            listaAeropuertosNoBase=LogicaNegocio.getListaAeropuetosDestino();
            comboBoxAeropuertos.setVisible(false);
            comboBoxAeropuertos.setEditable(false);
            lblSelect.setVisible(false);
            btnSeleccionar.setVisible(false);
            btnSeleccionar.setEnabled(false);
            mnuCompania.setEnabled(true);
            mnuVuelosBase.setEnabled(true);
            mnuVuelosDiarios.setEnabled(true);
            mnuConsultas.setEnabled(true);
            mnuAyuda.setEnabled(true);
            rbtAyudaContex.setVisible(true);
            LogicaNegocio.rellenarListaActualVuelosBase();//lista de vuyelos base que contega al aeropurto base
            LogicaNegocio.referenciarVuelosDiarioVueloBase();//una vez se tienen los vuelo base se les asocia sus vuelo diarios corresponsientes
            LogicaNegocio.rellenarListaActualVuelosDiarios();//vuelos diarios que contengan al aeropuerto base
            
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Persistencia.escribirCompaniaCsv();
        Persistencia.escribirListaVuelosBaseCsv();
        Persistencia.escribirVuelosDiariosCsv();
    }//GEN-LAST:event_formWindowClosing

    private void mnuConsultarVDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarVDiarioActionPerformed
        ConsultarVuelosDiarios consultarVuelosDiarios=new ConsultarVuelosDiarios(new JDialog(), true);
        consultarVuelosDiarios.setVisible(true);
    }//GEN-LAST:event_mnuConsultarVDiarioActionPerformed

    private void mnuModificarVDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarVDiarioActionPerformed
       ModificarVueloDiario modificarVueloDiario=new ModificarVueloDiario(this, true);
       modificarVueloDiario.setVisible(true);
    }//GEN-LAST:event_mnuModificarVDiarioActionPerformed

    private void mnuSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalidasActionPerformed

            PanelVuelosSalidaLlegada panel=new PanelVuelosSalidaLlegada(this, true);
            panel.setVisible(true);
    }//GEN-LAST:event_mnuSalidasActionPerformed

    private void mnuVuelosCompaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVuelosCompaniaActionPerformed
        PanelVuelosCompania panelesVueloscomapnia=new PanelVuelosCompania(this, true);
        panelesVueloscomapnia.setVisible(true);
    }//GEN-LAST:event_mnuVuelosCompaniaActionPerformed

    private void mnuVuelosDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVuelosDestinosActionPerformed
        PanelVuelosDestinoConcreto destinoConcreto=new PanelVuelosDestinoConcreto(this, true);
        destinoConcreto.setVisible(true);
    }//GEN-LAST:event_mnuVuelosDestinosActionPerformed

    private void mnuClimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClimaActionPerformed
        PanelTemperaturas temperaturas=new PanelTemperaturas(this, true);
        temperaturas.setVisible(true);
    }//GEN-LAST:event_mnuClimaActionPerformed

    private void mnuRecaudacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecaudacionActionPerformed
        PanelRecaudacion recaudacion=new PanelRecaudacion(this, true);
        recaudacion.setVisible(true);
    }//GEN-LAST:event_mnuRecaudacionActionPerformed

    private void mnuAyudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaSobreActionPerformed
        openWebView("https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/");
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAyudaSobreActionPerformed

    private void mnuAyudaCompaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaCompaniActionPerformed
        openWebView("https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-companias");
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAyudaCompaniActionPerformed

    private void mnuAyudaVueloBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaVueloBaseActionPerformed
        openWebView("https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-vuelo-base");
// TODO add your handling code here:
    }//GEN-LAST:event_mnuAyudaVueloBaseActionPerformed

    private void mnuAyudaVueloDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaVueloDiarioActionPerformed
        openWebView("https://propia.gitbook.io/ayuda-gestion-aplicacion-aeropuertos/gestion-vuelos-diarios");
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAyudaVueloDiarioActionPerformed

    private void rbtAyudaContexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAyudaContexActionPerformed
        if (rbtAyudaContex.isSelected()){
            btnAyudaComp.setVisible(true);
            btnAyudaVB.setVisible(true);
            btnAyudaVD.setVisible(true);
        }else{
            btnAyudaComp.setVisible(false);
            btnAyudaVB.setVisible(false);
            btnAyudaVD.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtAyudaContexActionPerformed

 

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaComp;
    private javax.swing.JButton btnAyudaVB;
    private javax.swing.JButton btnAyudaVD;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<Aeropuerto> comboBoxAeropuertos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblSelect;
    private javax.swing.JMenuItem mnuAltaVueloDiario;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaCompani;
    private javax.swing.JMenuItem mnuAyudaSobre;
    private javax.swing.JMenuItem mnuAyudaVueloBase;
    private javax.swing.JMenuItem mnuAyudaVueloDiario;
    private javax.swing.JMenuItem mnuClima;
    private javax.swing.JMenu mnuCompania;
    private javax.swing.JMenuItem mnuConsultarCmp;
    private javax.swing.JMenuItem mnuConsultarVDiario;
    private javax.swing.JMenuItem mnuConsultarVuelo;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenuItem mnuCrearCmp;
    private javax.swing.JMenuItem mnuCrearVuelo;
    private javax.swing.JMenuItem mnuEliminarCmp;
    private javax.swing.JMenuItem mnuEliminarVD;
    private javax.swing.JMenuItem mnuEliminarVuelo;
    private javax.swing.JMenuItem mnuModificarCmp;
    private javax.swing.JMenuItem mnuModificarVDiario;
    private javax.swing.JMenuItem mnuModificarVuelo;
    private javax.swing.JMenuItem mnuRecaudacion;
    private javax.swing.JMenuItem mnuSalidas;
    private javax.swing.JMenu mnuVuelosBase;
    private javax.swing.JMenuItem mnuVuelosCompania;
    private javax.swing.JMenuItem mnuVuelosDestinos;
    private javax.swing.JMenu mnuVuelosDiarios;
    private javax.swing.JRadioButton rbtAyudaContex;
    // End of variables declaration//GEN-END:variables
}
