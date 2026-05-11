package gestionComodines;

	public class GestionComodines {

	    // 1. 50:50 
		/**
		 * COMODÍN 50:50 (Versión Final)
		 * Elige 2 botones incorrectos al azar para ocultar.
		 */
		public int[] usar50porCientoFinal(int respuestaCorrecta) {
		    int[] incorrectas = new int[3];
		    int contador = 0;

		    // Guardamos los índices de los 3 botones que están mal
		    for (int i = 0; i < 4; i++) {
		        if (i != respuestaCorrecta) {
		            incorrectas[contador] = i;
		            contador++;
		        }
		    }

		    // Mezclamos las 3 opciones incorrectas
		    for (int i = 0; i < incorrectas.length; i++) {
		        int azar = (int) (Math.random() * incorrectas.length);
		        int temp = incorrectas[azar];
		        incorrectas[azar] = incorrectas[i];
		        incorrectas[i] = temp;
		    }

		    // Devolvemos las dos primeras de la mezcla
		    return new int[]{incorrectas[0], incorrectas[1]};
		}

	    // 2. LA RULETA 
	    /**
	     * COMODÍN DE LA RULETA (Versión Avanzada)
	     * Quita aleatoriamente 1, 2 o 3 respuestas incorrectas.
	     * @param respuestaCorrecta El índice de la opción que NO debe borrarse (0-3).
	     * @return Un array con los índices de las respuestas que la interfaz debe ocultar.
	     */
	    public int[] usarRuletaAleatoria(int respuestaCorrecta) {
	        // 1. La ruleta decide cuántas quitar: un número aleatorio entre 1 y 3
	        int cuantasQuitar = (int) (Math.random() * 3) + 1;
	        
	        int[] eliminar = new int[cuantasQuitar];
	        int cont = 0;
	        
	        // 2. Llenamos el array con las respuestas que NO son la correcta
	        // Recorremos las opciones (A=0, B=1, C=2, D=3)
	        for (int i = 0; i < 4; i++) {
	            // Si no es la correcta y aún no hemos llegado al límite que dijo la ruleta...
	            if (i != respuestaCorrecta && cont < cuantasQuitar) {
	                eliminar[cont] = i;
	                cont++;
	            }
	        }
	        
	        // Si la ruleta decidió quitar menos de las disponibles, 
	        // el array será más pequeño, lo cual es perfecto.
	        return eliminar;
	    }

	 // 3. LA LLAMADA DEL AMIGO
	    public String usarLlamada(int respuestaCorrecta) {
	        String[] opciones = {"A", "B", "C", "D"};
	        int probabilidadAcierto = (int) (Math.random() * 100);
	        int respuestaSugerida;

	        // Si el azar es mayor a 20 (80% de probabilidad), el amigo acierta
	        if (probabilidadAcierto > 20) {
	            respuestaSugerida = respuestaCorrecta;
	            return "Hola! Pues estoy casi seguro de que la respuesta correcta es la " + opciones[respuestaSugerida] + ".";
	        } else {
	            // El amigo se equivoca (20% de probabilidad) y elige una al azar que no sea la correcta
	            do {
	                respuestaSugerida = (int) (Math.random() * 4);
	            } while (respuestaSugerida == respuestaCorrecta);
	            
	            return "Uff, qué difícil... no lo sé seguro, pero yo diría que es la " + opciones[respuestaSugerida] + ".";
	        }
	    }

	    // 4. EL MAGO 
	 // 5. COMODÍN DEL CHAT
	    public int[] usarChat(int respuestaCorrecta) {
	        int[] porcentajes = new int[4];
	        int restante = 100;

	        // El chat suele acertar, pero le damos un rango amplio (40% al 90%)
	        porcentajes[respuestaCorrecta] = (int) (Math.random() * 51) + 40;
	        restante -= porcentajes[respuestaCorrecta];

	        // Repartimos el resto entre las incorrectas
	        for (int i = 0; i < 4; i++) {
	            if (i != respuestaCorrecta) {
	                int azar = (int) (Math.random() * (restante + 1));
	                // Si es la última opción que falta por rellenar, le damos todo lo sobrante
	                if (i == 3 || (i == 2 && respuestaCorrecta == 3) || (i == 1 && respuestaCorrecta >= 2)) {
	                    porcentajes[i] = restante;
	                    restante = 0;
	                } else {
	                    porcentajes[i] = azar;
	                    restante -= azar;
	                }
	            }
	        }
	        return porcentajes;
	    }

	    }

	