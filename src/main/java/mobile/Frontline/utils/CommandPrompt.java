package mobile.Frontline.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandPrompt {

	Process p;
	ProcessBuilder builder;

	public String runCommand(String command) throws InterruptedException, IOException {
		p = Runtime.getRuntime().exec(command);
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		String allLine = "";
		int i = 1;
		while ((line = r.readLine()) != null) {
			allLine = allLine + "" + line + "\n";
			if (line.contains("Console LogLevel: debug") && line.contains("Complete")) {
				break;
			}
			i++;
		}
		return allLine;

	}

	public String runCommandThruProcessBuilder(String command)
			throws InterruptedException, IOException {
		BufferedReader br = getBufferedReader(command);
		String line;
		String allLine = "";
		while ((line = br.readLine()) != null) {
			allLine = allLine + "" + line + "\n";
		}
		return allLine.split(":")[1].replace("\n", "").trim();
	}

	public String runProcessCommandToGetDeviceID(String command)
			throws InterruptedException, IOException {
		BufferedReader br = getBufferedReader(command);
		String line;
		String allLine = "";
		while ((line = br.readLine()) != null) {
			allLine = allLine.trim() + "" + line.trim() + "\n";
		}
		return allLine.trim();
	}

	private BufferedReader getBufferedReader(String command) throws IOException {
		List<String> commands = new ArrayList<>();
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			commands.add("/bin/sh");
			commands.add("-c");
		} else {
			commands.add("cmd.exe");
			commands.add("/c");
		}
		commands.add(command);
		ProcessBuilder builder = new ProcessBuilder(commands);
		final Process process = builder.start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	public void runCommandThruProcess(String command)
			throws InterruptedException, IOException {
		BufferedReader br = getBufferedReader(command);
		String line;
		String allLine = "";
		while ((line = br.readLine()) != null) {
			allLine = allLine + "" + line + "\n";
		}
	}
}
