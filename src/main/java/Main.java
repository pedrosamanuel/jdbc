public class Main {
    public static void main(String[] args){
        try{
            Dbconector db = new Dbconector();
            db.actualizarDpto();
            db.ConsultarDpto();
        } catch (Exception e){

        }

    }
}
