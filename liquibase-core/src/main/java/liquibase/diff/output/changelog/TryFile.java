package liquibase.diff.output.changelog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TryFile {
	private File file;
	List<String> dataList;
	public TryFile(File file)
	{
		this.file=file;
		dataList=new ArrayList<String>();
	}
	
	public void dataOfFile() throws IOException
	{
		try {
			FileReader obj=new FileReader(file);
			BufferedReader red=new BufferedReader(obj);
			String cade;
			while ((cade = red.readLine())!=null) {
				
				dataList.add(this.replaceData(cade));
				//System.out.println();
			}
			red.close();
			obj.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifu()
	{
		String ruta=file.getAbsolutePath();
		file.delete();
		FileWriter fichero=null;
		PrintWriter pw=null;
		try {
			FileOutputStream stream = new FileOutputStream(ruta);
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);
			for(String cad:dataList)
			{
				pw.println(cad);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	private String replaceData(String info)
	{
		info=info.replaceAll("INT\\([0-9]*\\)", "INT");
		info=info.replaceAll("SMALLINT\\([0-9]*\\)", "SMALLINT");
		info=info.replaceAll("TINYINT\\([0-9]*\\)", "TINYINT");
		return info;
	}
}
