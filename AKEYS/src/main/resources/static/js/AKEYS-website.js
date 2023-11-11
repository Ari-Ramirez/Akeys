

// Open the full-screen search box
function openSearch() {
  document.getElementById("myOverlay").style.display = "block";
}

// Close the full-screen search box
function closeSearch() {
  document.getElementById("myOverlay").style.display = "none";
}


//   search options
const products = [
{ name: 'GMK HINEYBEIGE', url: 'keycaps' },
{ name: 'CYL TAKO', url: 'keycaps' },
{ name: 'CYL ART CR', url: 'keycaps' },
{ name: 'CYL ART RB', url: 'keycaps' },
{ name: 'R2-D2™', url: 'keycaps' },
{ name: 'BB-8™', url: 'keycaps' },
{ name: 'GHOSTBUSTIN', url: 'keycaps' },
{ name: 'CYL INFERNAL', url: 'keycaps' },
{ name: 'N65-Awaken', url: 'keyboards' },
{ name: 'N65 TFUE', url: 'keyboards' },
{ name: '87 - DARKSHAKE', url: 'keyboards' },
{ name: 'N65 - MICTLAN', url: 'keyboards' },
{ name: 'MONOKEI STANDARD', url: 'keyboards' },
{ name: 'N65 - ALUMINUM', url: 'keyboards' },
{ name: 'N87 - ALUMINUM', url: 'keyboards' },
{ name: 'QMX STABILIZERS', url: 'home' },
{ name: 'CREAM CLICKIE', url: 'switches' },
{ name: 'NK_ CREAM™', url: 'switches' },
{ name: 'NK_ CREAM™ BLU', url: 'switches' },
{ name: 'GATERON KANGAROO', url: 'switches' },
{ name: 'NK SILK AWAKEN', url: 'switches' },
{ name: 'MM Switches', url: 'switches' },
{ name: 'KAILH SWITCHES', url: 'switches' },
{ name: 'KAILH BOX SWITCHES', url: 'switches' },
];

// Function to filter and redirect based on search input
function filterProductsByName() {
const searchInput = document.getElementById('searchInput').value.toLowerCase();

// Loop through the product data to find a match
for (const product of products) {
    if (product.name.toLowerCase() === searchInput) {
        // If a match is found, redirect to the specified URL
        window.location.href = product.url;
        return;
    }
}

}