package uscs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Cinza {

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
        for (int i = 1; i < W; i++) {
            for (int j = 1; j < H; j++) {
            	
                int piexel1 = image.getRGB(i, j);
                int blue1 = piexel1 & 0xFF;//
                int green1 = (piexel1 >> 8) & 0xFF;
                int red1 = (piexel1 >> 16) & 0xFF;
                
                int bluefinal = red1;
                int redfinal = red1;
                int greenfinal = red1;
                
                int[] color = {redfinal, greenfinal, bluefinal};
                outputRaster.setPixel(i, j, color);
            }
        }
        //Salva a imagem filtrada
        ni.setData(outputRaster);
        ImageIO.write(ni, "JPEG", new File("image1.jpg"));
    }
    
}
