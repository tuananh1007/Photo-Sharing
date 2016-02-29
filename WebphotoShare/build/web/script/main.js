function toggleDiv(divID) {
    var showhideStyle = document.getElementById(divID).style;
    if ( showhideStyle.display == "block" ) {
     	showhideStyle.display = "none";
    } else {
    	showhideStyle.display = "block";
    }
} 