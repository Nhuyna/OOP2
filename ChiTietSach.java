import java.io.BufferedReader;
import java.io.FileReader;

public class ChiTietSach {
    protected String idBIteam;
    protected Sach Book;
    protected boolean situation;
    protected viTri viTri;
   public ChiTietSach(){

   }
   public ChiTietSach(String idBItem,Sach Book, boolean situation,viTri viTri){
     this.idBIteam=idBItem;
     this.Book=Book;
     this.situation=situation;
     this.viTri=viTri;
   }

    public void setIdBIteam(String idBIteam) {
        this.idBIteam = idBIteam;
    }

    public String getIdBIteam() {
        return idBIteam;
    }

    public viTri getviTri() {
        return viTri;
    }
    public void setviTri(viTri viTri) {
        this.viTri = viTri;
    }
    public void setviTri() {
        if(situation==false){
            this.viTri=null;
        }
    }
    
    public Sach getBook() {
        return Book;
    }

    public void setBook(Sach Book) {
        this.Book = Book;
    }
    public void setSituation(boolean situation) {
        this.situation = situation;
    }

     public boolean getSituation(){
        return situation;
     }    
   
    @Override
   public String toString(){
   
    return String.format("%5s%10s%10s%10s", getIdBIteam(),getBook().getName(),getSituation(),(getSituation())?viTri.toString():"null");
   }
   public static ChiTietSach[] addElementChiTietSach(ChiTietSach[] Sach, ChiTietSach tmp) {
    ChiTietSach[] array = new ChiTietSach[Sach.length+1];
    System.arraycopy(Sach, 0, array, 0, Sach.length);
    array[Sach.length] = tmp;
    return array;}
    public static ChiTietSach SearchId(ChiTietSach DS[],String a){
        for(ChiTietSach x : DS){
             if(x.getIdBIteam().equals(a)){
               
              return x;
             }
        }
          return null;
      }

      public static ChiTietSach[] DocGhiDuLieuChiTietSach(boolean a,ChiTietSach CTSach[]){
        
          if(a){
             
            // try {
            //  FileWriter fw =new
            //   FileWriter("./data/ChiTietSach.txt");
            //  BufferedWriter bw =new BufferedWriter(fw);
            //            bw.write(""+CTSach.length);
            //            bw.newLine();
            //            for(ChiTietSach t:CTSach){
            //              // bw.write(t.toString());
                        
            //             bw.write(t.id+";"+t.name+";"+t.Author.idA+";"+t.category.idC);
            //             bw.newLine();
            //            }
            //            bw.close();
            //            fw.close();
            //      } catch (Exception e) {
            //      }
                  
                 }
                 else{
                        try {
                          int slCTSach;
                         FileReader fr=new FileReader("./data/ChiTietSach.txt");
                         BufferedReader br =new BufferedReader(fr);
                         String line="";
                         slCTSach = Integer.parseInt(br.readLine());                      
                         //Đọc dữ liệu sách
                          Sach Sach[]=new Sach[0];
                
                          Sach=Sach.DocGhiDuLieuSach(false,Sach);            
                         //Đọc dữ liệu vị trí
                                viTri ViTri[]=new viTri[0];
                                ViTri=viTri.DocGhiDuLieuViTri(false, ViTri);
                                // for(viTri l : ViTri){
                                //   System.out.println(l.toString());
                                // }
                          
                                int i=0;
                          while(true){
                             line=br.readLine();
                             if(line ==""){
                                 break;
                             }
                             String txt[]=line.split(";");
                             String id=txt[0];
                             String book=txt[1];
                             boolean situation= Boolean.parseBoolean(txt[2]);
                             String viTri=txt[3];
                             
                             
                                 Sach x=Sach.SearchId(Sach, book);
                                 viTri y=(viTri.SearchId(ViTri,viTri));
                                if(y==null){
                                  System.out.println("Tìm kh thấy"+i+++" " + viTri);
                                }
                                 ChiTietSach c=new ChiTietSach(id, x,situation,y);
                                //  System.out.println(Authors.SearchIdA(tmpA, author).getName());
                                  // System.out.println(c.idBIteam+"   "+c.getBook().name+"   "+c.situation+"  "+c.getviTri().toString());
        
                               CTSach=ChiTietSach.addElementChiTietSach(CTSach, c);
                              //  System.out.println(c.idBIteam+"  "+c.getBook().name+"  "+c.situation + "  "+ c.viTri.toString());
                              //  System.out.println(c.toString());
                                             }
                                             br.close();
                                             fr.close();
                                     } catch (Exception e) {
                                         
                                     }
                                     }
        
                                 return CTSach;
        }

}
