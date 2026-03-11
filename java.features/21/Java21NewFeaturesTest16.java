import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Java21NewFeaturesTest16 {

        public static void main(String[] args) throws IOException, InterruptedException {
                ProcessBuilder builder = new ProcessBuilder();

                builder.command("ls", "-l", "/tmp");

                Path temp = Files.createTempFile("hello", "world");

                builder.redirectOutput(temp.toFile());

                Process process = builder.start();

                process.waitFor();

                try {
                        String output = new String(Files.readAllBytes(temp));

                        System.out.println(output);
                } finally {
                        Files.deleteIfExists(temp);
                }
        }
}
/**
 * Output:
        total 80
        drwx------ 2 ovo  ovo  4096 Mar 11 08:28 com.google.Chrome.CSHgGi
        -rw------- 1 ovo  ovo     0 Mar 11 09:03 hello16623931951890733813world
        drwxr-xr-x 2 ovo  ovo  4096 Mar 11 09:03 hsperfdata_ovo
        drwx------ 2 ovo  ovo  4096 Mar 11 08:56 mcp-T3iinl
        drwx------ 2 ovo  ovo  4096 Mar 11 08:57 pyright-8680-YUXr0FWp9OTb
        drwxrwxr-x 3 ovo  ovo  4096 Mar 11 08:57 python-languageserver-cancellation
        drwx------ 4 root root 4096 Mar 11 09:00 snap-private-tmp
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-bluetooth.service-yNoiYE
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-colord.service-IYVnUw
        drwx------ 3 root root 4096 Mar 11 09:00 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-fwupd.service-8Ih71S
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-ModemManager.service-I4W7xt
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-polkit.service-Uf4auL
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-power-profiles-daemon.service-oUQVvO
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-switcheroo-control.service-ewcfhp
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-logind.service-4m6KFb
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-oomd.service-VPurMT
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-resolved.service-RAxU5c
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-systemd-timesyncd.service-WpoytK
        drwx------ 3 root root 4096 Mar 11 08:25 systemd-private-f8faf0446766409f9d71d8a8c84a23a7-upower.service-CzQ3o8
        drwxrwxrwt 2 root root 4096 Mar 11 08:25 VMwareDnD
        drwx------ 2 root root 4096 Mar 11 08:25 vmware-root_836-2722107930
 */