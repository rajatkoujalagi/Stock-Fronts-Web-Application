package db.connect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CleanData {

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 30; i++) {
			String path = "C:/Users/Vishu/Desktop/DatabaseInput/";
			String extension = ".csv";
			String inputFileName= "201403"+String.valueOf(i)+extension;
			String outputFileName= "201403"+String.valueOf(i+1)+extension;
			BufferedReader br = new BufferedReader(new FileReader(path+inputFileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter(path+outputFileName));
			String cvsSplitBy = ",";
			String line = br.readLine();
			String[] firstColumns = line.split(cvsSplitBy);
			bw.write(firstColumns[0]);
			bw.write(",");
			bw.write(firstColumns[1]);
			bw.write(",");
			bw.write(firstColumns[2]);
			bw.write(",");
			bw.write(firstColumns[3]);
			bw.write(",");
			bw.write(firstColumns[4]);
			bw.newLine();
			while ((line = br.readLine()) != null) {

				String[] columns = line.split(cvsSplitBy);
				bw.write(columns[0]);
				bw.write(",");
				bw.write(columns[1]);
				bw.write(",");
				bw.write(columns[2]);
				bw.write(",");
				bw.write(String.valueOf(Integer.parseInt(columns[3]) + 1));
				bw.write(",");
				double oldPrice = Double.parseDouble(columns[4]);
				double newPrice = oldPrice * Math.random() * 2;
				bw.write(String.valueOf(newPrice));
				bw.newLine();

			}
			br.close();
			bw.close();
		}
	}

}
