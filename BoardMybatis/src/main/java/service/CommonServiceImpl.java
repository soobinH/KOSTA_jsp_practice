package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class CommonServiceImpl implements CommonService {

	@Override
	public void imageView(String realPath, String filename, OutputStream out) throws Exception {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(realPath,filename));
			byte[] buff = new byte[4096];
			int len;
			while((len=fis.read(buff))>0) {
				out.write(buff,0,len);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
