
function idleLogout() {
    let t;
    window.onload = resetTimer;

    let downloadTimer;
    function showModal() {
        $('#the-modal').modal({
            show: true
        });

        let timeleft = 30;
        downloadTimer = setInterval(function(){
            timeleft--;
            document.getElementById("seconds").textContent = timeleft;
            if(timeleft <= 0){
                clearInterval(downloadTimer);
                //close modal
                $('#the-modal').modal({
                    show: false
                });
                //redirect to home
                console.log("whaat");
                window.location.replace("/login?timeout");
            }
        },1000);
    }

    //Shows modal after 30 seconds
    function resetTimer() {
        clearTimeout(t);
        t = setTimeout(showModal, 30000);  // time is in milliseconds
    }

    const refreshButton = document.getElementById("refresh-button");
    refreshButton.addEventListener("click", pingServer);

    //refreshes the session
    function pingServer(){
        $.ajax({url: "/",type: "HEAD",complete: function (XMLHttpRequest, textStatus) {}});
        clearInterval(downloadTimer);
        resetTimer();
    }

}

//Redirect to login after the session expires
idleLogout();


window.addEventListener('unload', function(event) {
    console.log('I am the one.');
    $.ajax({
        type: "POST",
        url: "/login",
        data: { name: "Ahmed"} // parameters
    })
});

