<?php
function inverso($x) {
    if (!$x) {
        throw new Exception('División por cero.');
    }
    return 1/$x;
}

try {
    echo inverso(5) . "\n";
    echo inverso(0) . "\n";
} catch (Exception $e) {
    echo 'Excepción capturada: ',  $e->getMessage(), "\n";
}

// Continuar la ejecución
echo 'Hola Mundo\n';
?>