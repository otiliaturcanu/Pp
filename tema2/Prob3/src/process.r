library("lattice")
relation <- lm(y~x)

salvare <- paste(location,name)


png(file = salvare)
xyplot(x ~ y, data = iris)
dev.off()