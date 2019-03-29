<!DOCTYPE html>
<html lang="en">
<body>
<h2>Booking operations</h3>
        <h2>User Requests</h2>
        <form action="user/email" method="get">
            <div> <span>Get by Email : <input type="text" name="email"> </span>
            <input type="submit" value="Submit"></div>
        </form>
        <br>
        <form action="user/name" method="get">
                    <div> <span>Get by Name : <input type="text" name="name"> </span>
                        <input type="submit" value="Submit"></div>
        </form>
        <br>
        <h2>Event Requests</h2>
        <form action="event/name" method="get">
            <div> <span>Get by Name : <input type="text" name="name"> </span>
            <input type="submit" value="Submit"></div>
        </form>
        <br>
                    <div><a href="event">Get all events</a></div>
        <br>
        <br>
                <form name="uploadingForm" enctype="multipart/form-data" action="upload" method="POST">
                    <p>
                        <input id="fileInput" type="file" name="uploadingFile" onchange="updateSize();">
                        selected files: <span id="fileNum">0</span>;
                        total size: <span id="fileSize">0</span>
                    </p>
                    <p>
                        <input type="submit" value="Upload files">
                    </p>
                </form>
                <script>
                            function updateSize() {
                                var nBytes = 0,
                                        oFiles = document.getElementById("fileInput").files,
                                        nFiles = oFiles.length;
                                for (var nFileId = 0; nFileId < nFiles; nFileId++) {
                                    nBytes += oFiles[nFileId].size;
                                }
                                var sOutput = nBytes + " bytes";
                                // optional code for multiples approximation
                                for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
                                    sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
                                }
                                // end of optional code
                                document.getElementById("fileNum").innerHTML = nFiles;
                                document.getElementById("fileSize").innerHTML = sOutput;
                            }
                     </script>
</body>
</html>