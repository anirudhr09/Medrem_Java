import java.util.*;
/**
 *
 * @author ARS
 */
class company_info extends Thread
{
    @Override
    public void run()
    {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\t\t\t MEDREM \t\t\t");
        System.out.println("------------------------------------------------------------------------------");
    }
}
class about_us extends Thread
{
    @Override
    public void run()
    {
        System.out.println("\n\n\n\n");
        System.out.println("CONTACT US AT");
        System.out.println("Contact no: 99123 45611");
        System.out.println("Email: anirudhramesh2002@gmail.com");
        System.out.println("\n\n\n");
    }
}
class tag_line extends Thread
{
    @Override
    public void run()
    {
        System.out.println("\t\t A place to REMember your MEDicines");
    }
}
class medication
{
    String med_name;
    String time;
    public medication()
    {
        med_name = " ";
        time =" ";
    }
    public void medicines(String m,String t)
    {
        med_name=m;
        time=t;
    }
}
class details
{
    public String name;
    public int age;
    Vector <medication> meds = new Vector();
}
public class Main
{
    //static Vector <details> det = new Vector();
    static void add(Vector <details> det)
    {
        //System.out.print("\033[H");
        //System.out.flush();
        System.out.println("--------------------------------------------------");
        System.out.println("ADD DETAILS");
        System.out.println("--------------------------------------------------");
        details d= new details();
        String cont;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter name: ");
        d.name=cin.nextLine();
        System.out.println("Enter age: ");
        d.age=Integer.parseInt(cin.nextLine());
        System.out.println("Enter med details: ");
        do
        {
        medication m = new medication();
        System.out.println("Enter med name:");
        String name=cin.nextLine();
        System.out.println("Enter med timing:");
        String time=cin.nextLine();
        m.medicines(name, time);
        d.meds.add(m);
        System.out.println("Do you want to add more? (y/n)");
        cont=cin.nextLine();
        }
        while("y".equals(cont));
        det.add(d);
        System.out.println("Successfully added..");
    }

    static void search(Vector <details> det)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("SEARCH DETAILS");
        System.out.println("--------------------------------------------------");
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter Username to Search: ");
        //    for(int i=0;i<)
        String sname=cin.nextLine();
        System.out.println("-------------------------------------------");
        for(int j=0;j<det.size();j++)
        {
            //System.out.println(det.get(j).name);
            //System.out.println(det.get(j).age);
            //System.out.println(det.size());
            //System.out.println(det.get(j).meds.size());
            String cname=det.get(j).name;
            if(sname.equals(cname))
            {
            System.out.println(cname);
            for(int k=0; k<det.get(j).meds.size(); k++)
            {
                System.out.println(det.get(j).meds.get(k).med_name);
            }
            System.out.println("-------------------------------------------");
            }
        }
    }
    static void remove(Vector <details> det)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("REMOVE DETAILS");
        System.out.println("--------------------------------------------------");
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter username to remove user");
        String rname= cin.nextLine();
        for(int i=0 ; i<det.size() ; i++)
        {
            String cname=det.get(i).name;
            if(cname.equals(rname))
            {
                det.remove(i);
                System.out.println("Removed User..");
            }
            else
            System.out.println("User Unavailable");
        }
    }
    static void update(Vector <details> det)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("UPDATE DETAILS");
        System.out.println("--------------------------------------------------");
        //medication m = new medication();
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter user to update:");
        String uname=cin.nextLine();
        for(int i=0 ; i<det.size() ; i++)
        {
            String cname=det.get(i).name;
            if(cname.equals(uname))
            {
                int ch_meds;
                String cont;
                System.out.println("1.Add meds");
                System.out.println("2.Remove meds");
                System.out.println("Enter choice: ");
                ch_meds=Integer.parseInt(cin.nextLine());
                switch(ch_meds)
                {
                    case 1:
                    {
                        do
                        {
                        System.out.println("--------------------------------------------------");
                        System.out.println("ADD MEDICINE");
                        System.out.println("--------------------------------------------------");
                        medication m = new medication();
                        System.out.println("Enter medicine name:");
                        String name=cin.nextLine();
                        System.out.println("Enter medicine timing:");
                        String time=cin.nextLine();
                        m.medicines(name, time);
                        det.get(i).meds.add(m);
                        System.out.println("--------------------------------------------------");
                        System.out.println("Do you want to add more? (y/n)");
                        cont=cin.nextLine();
                        }
                        while("y".equals(cont));
                        break;
                    }
                    case 2:
                    {
                        //Scanner cin = new Scanner(System.in);
                        System.out.println("--------------------------------------------------");
                        System.out.println("REMOVE MEDICINE");
                        System.out.println("--------------------------------------------------");
                        System.out.println("Enter Medicine to remove: ");
                        String rname= cin.nextLine();
                        for(int j=0 ; j<det.get(i).meds.size() ; j++)
                        {
                            String rmname=det.get(i).meds.get(j).med_name;
                            if(rmname.equals(rname))
                            {
                                det.get(i).meds.remove(j);
                                System.out.println("Removed Successfully..");
                            }
                            else
                            {
                                System.out.println("Medicine Unavailable..");
                            }
                        }
                        break;
                    }
                    default: System.out.println("Invalid choice!!");
                }
            }
            
        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        Scanner cin = new Scanner(System.in);
        company_info c= new company_info();
        Vector <details> det = new Vector();
        tag_line tag= new tag_line();
        about_us au = new about_us();
        c.start();
        c.join();
        tag.start();
        tag.join();
        au.start();
        au.join();
        int ch;
        String cont="y";
        while("y".equals(cont))
        {
        System.out.println("ENTER CHOICE:");
        System.out.println("1.Add");
        System.out.println("2.Search");
        System.out.println("3.Update");
        System.out.println("4.Remove");
        ch=Integer.parseInt(cin.nextLine());
        switch(ch)
        {
            case 1 :
                {
                    add(det);
                    break;
                }
            case 2 :
                {
                    search(det);
                    break;
                }
            case 3 :
                {
                    update(det);
                    break;
                }
            case 4 :
                {
                    remove(det);
                    break;
                }
            default : 
            {
                System.out.println("Invalid choice");
                break;
            }
        }
        System.out.println("Do you want to continue?(y/n)");
        cont=cin.nextLine();
        }
        System.out.println("Thank you for using");
    }
}
