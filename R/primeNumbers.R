isPrime = function(x) {

    if(x == 1) {
        return(FALSE)
    }

    if(x <= 2) {
        return(TRUE)
    }

    for(i in 2: (x / 2)) {
        if(x %% i == 0) {
            return(FALSE)
        }
    }
    return(TRUE)
}

find100Prime = function() {

    vector = c()
    i = 1
    while(length(vector) <= 100) {
        if(isPrime(i)) {
            vector = append(vector, i)
        }
        i = i + 1
    }

    return(vector)
}

find100Prime()
