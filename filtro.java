package uscs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException{
    	//Bloco de código-fonte necessário para o usuário localizar e abrir o arquivo
        File arquivo = null;
        JFileChooser chooser = new JFileChooser();    
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF Images", "jpg", "gif", "png");  
        chooser.setFileFilter(filter);    
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) { 
            arquivo = chooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null,"Não foi Possível Abrir o Arquivo!",""
                +"Cancelar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Carrega a imagem (arquivo) que foi selecionado pelo usuário
        BufferedImage image = ImageIO.read(arquivo);
        
        //Obtém o tamanho da imagem
        int H = image.getHeight(null);
        int W = image.getWidth(null);
        
        //Criar nova imagem com novas dimensoes
        BufferedImage ni = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
        
        //Obtém a imagem (ni) pegando o valor de cada pixel para criar uma matriz retangular de pixels para a imagem com a filtragem
        WritableRaster outputRaster = ni.getRaster();
        
        //aplica a máscara a cada pixel
        for (int i = 1; i < W-1; i++) {
            for (int j = 1; j < H-1; j++) {
            	
                int piexel1 = image.getRGB(i, j);
                int blue1 =  piexel1 & 0xFF;//
                int green1 = (piexel1 >> 8) & 0xFF;
                int red1 =  (piexel1 >> 16) & 0xFF;
                
                int pixel2 =  image.getRGB(i - 1, j - 1);
                int blue2 =  pixel2 & 0xFF;
                int green2 =  (pixel2 >> 8) & 0xFF;
                int red2 =  (pixel2 >> 16) & 0xFF;
                
                int pixel3 = image.getRGB(i - 1, j);
                int blue3 =  pixel3 & 0xFF;
                int green3 =  (pixel3 >> 8) & 0xFF;
                int red3 =  (pixel3 >> 16) & 0xFF;
                //System.out.println(i + " " + j + " " + H + "  " + W);
                
                int pixel4 = image.getRGB(i - 1, j + 1);
                int blue4 = pixel4 & 0xFF;
                int green4 =  (pixel4 >> 8) & 0xFF;
                int red4 =  (pixel4 >> 16) & 0xFF;
                
                int pixel5 = image.getRGB(i, j - 1);
                int blue5 =  pixel5 & 0xFF;
                int green5 =   (pixel5 >> 8) & 0xFF;
                int red5 =   (pixel5 >> 16) & 0xFF;
                
                int pixel6 = image.getRGB(i, j + 1);
                int blue6 = pixel6 & 0xFF;
                int green6 = (pixel6 >> 8) & 0xFF;
                int red6 = (pixel6 >> 16) & 0xFF;
                
                int pixel7 = image.getRGB(i + 1, j - 1);
                int blue7 =   pixel7 & 0xFF;
                int green7 =   (pixel7 >> 8) & 0xFF;
                int red7 =   (pixel7 >> 16) & 0xFF;
                
                int pixel8 = image.getRGB(i + 1, j);
                int blue8 = pixel8 & 0xFF;
                int green8 = (pixel8 >> 8) & 0xFF;
                int red8 = (pixel8 >> 16) & 0xFF;
                
                int pixel9 = image.getRGB(i + 1, j - 1);
                int blue9 = pixel9 & 0xFF;
                int green9 = (pixel9 >> 8) & 0xFF;
                int red9 = (pixel9 >> 16) & 0xFF;
                
                // filtro 1
//                int bluefinal = (blue1 + blue2 + blue3 + blue4 + blue5 + blue6 + blue7 + blue8 + blue9)/9 ;
//                int redfinal = (red1 + red2 + red3 + red4 + red5 + red6 + red7 + red8 + red9)/9 ;
//                int greenfinal = (green1 + green2 + green3 + green4 + green5 + green6 + green7 + green8 + green9)/9 ;
                
                // filtro passa-baixa 1/10                
//                int bluefinal = (blue1*2 + blue2 + blue3 + blue4 + blue5 + blue6 + blue7 + blue8 + blue9)/10;
//                int redfinal = (red1*2 + red2 + red3 + red4 + red5 + red6 + red7 + red8 + red9)/10;
//                int greenfinal = (green1*2 + green2 + green3 + green4 + green5 + green6 + green7 + green8 + green9)/10;
//                
                // filtro passa-baixa 1/16
//                int bluefinal = (blue1*2 + blue2 + blue3*2 + blue4 + blue5*2 + blue6*2 + blue7 + blue8*2 + blue9)/16;
//                int redfinal = (red1*2 + red2 + red3*2 + red4 + red5*2 + red6*2 + red7 + red8*2 + red9)/16;
//                int  greenfinal = (green1*2 + green2 + green3*2 + green4 + green5*2 + green6*2 + green7 + green8*2 + green9)/16;
                
                // filtro passa-alta 5
//                int bluefinal = (blue1*5 + blue2*0 + blue3*(-1) + blue4*0 + blue5*(-1) + blue6*(-1) + blue7*0 + blue8*(-1) + blue9*0);
//	            int redfinal = (red1*5 + red2*0 + red3*(-1) + red4*0 + red5*(-1) + red6*(-1) + red7*0 + red8*(-1) + red9*0);
//	            int greenfinal = (green1*5 + green2*0 + green3*(-1) + green4*0 + green5*(-1) + green6*(-1) + green7*0 + green8*(-1) + green9*0);
//	            
	            // filtro passa-alta 9
//	            int bluefinal = (blue1*9 + blue2*(-1) + blue3*(-1) + blue4*(-1) + blue5*(-1) + blue6*(-1) + blue7*(-1) + blue8*(-1) + blue9*(-1));
//	            int redfinal = (red1*9 + red2*(-1) + red3*(-1) + red4*(-1) + red5*(-1) + red6*(-1) + red7*(-1) + red8*(-1) + red9*(-1));
//	            int greenfinal = (green1*9 + green2*(-1) + green3*(-1) + green4*(-1) + green5*(-1) + green6*(-1) + green7*(-1) + green8*(-1) + green9*(-1));
	            
	            // filtro passa-alta 5 - 2
//	            int bluefinal = (blue1*5 + blue2 + blue3*(-2) + blue4 + blue5*(-2) + blue6*(-2) + blue7 + blue8*(-2) + blue9);
//	            int redfinal = (red1*5 + red2 + red3*(-2) + red4 + red5*(-2) + red6*(-2) + red7 + red8*(-2) + red9);
//	            int greenfinal = (green1*5 + green2 + green3*(-2) + green4 + green5*(-2) + green6*(-2) + green7 + green8*(-2) + green9);
	            
                // filtro passa-alta norte
	            int bluefinal = (blue1*2 + blue2 + blue3 + blue4 + blue5 + blue6 + blue7*(-1) + blue8*(-1) + blue9*(-1));
	            int redfinal = (red1*2 + red2 + red3 + red4 + red5 + red6 + red7*(-1) + red8*(-1) + red9*(-1));
	            int greenfinal = (green1*2 + green2 + green3 + green4 + green5 + green6 + green7*(-1) + green8*(-1) + green9*(-1) );
	            
	            
              
                int[] color = {redfinal, greenfinal, bluefinal};
                outputRaster.setPixel(i, j, color);
            }
        }
        //Salva a imagem filtrada
        ni.setData(outputRaster);
        ImageIO.write(ni, "JPEG", new File("img-passa-alta-04.jpg"));
    }
    
}
