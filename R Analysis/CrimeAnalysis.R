##                      Chicago Crime Analysis

##Read the crime data present in local drive
crimedata <- read.csv("C:\\Project\\Crimes_-_2001_to_present.csv")

## find the dimensions of loaded crimedata
dim(crimedata)
##  [1] 6209067      22

str(crimedata)
##
## 'data.frame':	6209067 obs. of  22 variables:
##  $ ID                  : int  3047146 3047147 3047148 3047149 3047150 3047151 3047152 3047153 3047154 3047155 ...
## $ Case.Number         : Factor w/ 6208738 levels "","01G050460",..: 1386152 1385496 1384391 1384145 1385061 1385784 1386508 1385627 1386043 1384711 ...
# $ Date                : Factor w/ 2461178 levels "01/01/2001 01:00:00 AM",..: 2186523 2180457 2180082 2180474 2180467 2186332 2192954 2186780 2186537 2180257 ...
# $ Block               : Factor w/ 58705 levels "0000X  I94/EXIT 12",..: 12909 1512 12587 28411 13532 2444 12449 25144 15652 14784 ...
# $ IUCR                : Factor w/ 400 levels "0110","0130",..: 114 160 162 160 20 42 106 54 32 162 ...
# $ Primary.Type        : Factor w/ 35 levels "ARSON","ASSAULT",..: 18 7 8 7 31 3 18 3 3 8 ...
# $ Description         : Factor w/ 378 levels "$300 AND UNDER",..: 331 339 338 339 54 315 86 136 41 338 ...
# $ Location.Description: Factor w/ 172 levels "","ABANDONED BUILDING",..: 154 35 119 19 17 150 154 150 150 134 ...
# $ Arrest              : Factor w/ 2 levels "false","true": 1 1 2 1 1 1 1 1 1 2 ...
# $ Domestic            : Factor w/ 2 levels "false","true": 1 1 1 1 1 1 1 2 1 1 ...
# $ Beat                : int  1433 1332 1213 823 1323 1331 734 1331 1222 1233 ...
# $ District            : int  14 12 12 8 12 12 7 12 12 12 ...
# $ Ward                : int  1 2 25 15 1 2 17 2 25 25 ...
# $ Community.Area      : int  24 28 28 66 24 27 67 27 31 31 ...
# $ FBI.Code            : Factor w/ 26 levels "01A","01B","02",..: 9 17 26 17 4 11 9 11 6 26 ...
# $ X.Coordinate        : int  1166109 1162391 1166865 1153746 1165828 1156350 1167587 1156185 1167990 1172610 ...
# $ Y.Coordinate        : int  1910296 1900876 1897146 1862609 1907418 1901289 1856659 1900529 1891334 1891764 ...
# $ Year                : int  2003 2003 2003 2003 2003 2003 2003 2003 2003 2003 ...
# $ Updated.On          : Factor w/ 1175 levels "01/01/2007 07:32:02 AM",..: 298 298 298 298 298 298 298 298 298 298 ...
# $ Latitude            : num  41.9 41.9 41.9 41.8 41.9 ...
# $ Longitude           : num  -87.7 -87.7 -87.7 -87.7 -87.7 ...
# $ Location            : Factor w/ 841448 levels "","(36.619446395, -91.686565684)",..: 581972 493986 456574 247618 554739 498676 190413 490780 422849 425703 ...

## get some rows with headings
head(crimedata)

# > head(crimedata)
# ID Case.Number                   Date                   Block IUCR        Primary.Type
# 1 3047146    HJ761838 11/15/2003 07:30:00 PM   015XX N GREENVIEW AVE 0930 MOTOR VEHICLE THEFT
# 2 3047147    HJ760675 11/14/2003 11:00:00 PM       001XX N HOYNE AVE 1310     CRIMINAL DAMAGE
# 3 3047148    HJ758922 11/14/2003 01:45:38 PM     014XX W FLOURNOY ST 1330   CRIMINAL TRESPASS
# 4 3047149    HJ758506 11/14/2003 11:17:22 AM         035XX W 63RD ST 1310     CRIMINAL DAMAGE
# 5 3047150    HJ759944 11/14/2003 11:10:00 PM       015XX W THOMAS ST 031A             ROBBERY
# 6 3047151    HJ761196 11/15/2003 02:15:00 PM 002XX N SACRAMENTO BLVD 0460             BATTERY
# Description Location.Description Arrest Domestic Beat District Ward Community.Area FBI.Code
# 1 THEFT/RECOVERY: AUTOMOBILE               STREET  false    false 1433       14    1             24       07
# 2                TO PROPERTY        CHA APARTMENT  false    false 1332       12    2             28       14
# 3                    TO LAND                OTHER   true    false 1213       12   25             28       26
# 4                TO PROPERTY            APARTMENT  false    false  823        8   15             66       14
# 5             ARMED: HANDGUN                ALLEY  false    false 1323       12    1             24       03
# 6                     SIMPLE             SIDEWALK  false    false 1331       12    2             27      08B
# X.Coordinate Y.Coordinate Year             Updated.On Latitude Longitude                      Location
# 1      1166109      1910296 2003 04/15/2016 08:55:02 AM 41.90943 -87.66522 (41.909434286, -87.665221645)
# 2      1162391      1900876 2003 04/15/2016 08:55:02 AM 41.88366 -87.67914 (41.883663723, -87.679143787)
# 3      1166865      1897146 2003 04/15/2016 08:55:02 AM 41.87333 -87.66282 (41.873333547, -87.662821937)
# 4      1153746      1862609 2003 04/15/2016 08:55:02 AM 41.77883 -87.71191 (41.778830658, -87.711905593)
# 5      1165828      1907418 2003 04/15/2016 08:55:02 AM 41.90154 -87.66634  (41.901542862, -87.66633612)
# 6      1156350      1901289 2003 04/15/2016 08:55:02 AM 41.88492 -87.70132  (41.88492126, -87.701315736)
# 

#column names
names(crimedata)

# > names(crimedata)
# [1] "ID"                   "Case.Number"          "Date"                 "Block"               
# [5] "IUCR"                 "Primary.Type"         "Description"          "Location.Description"
# [9] "Arrest"               "Domestic"             "Beat"                 "District"            
# [13] "Ward"                 "Community.Area"       "FBI.Code"             "X.Coordinate"        
# [17] "Y.Coordinate"         "Year"                 "Updated.On"           "Latitude"            
# [21] "Longitude"            "Location"  

# Quick summary
summary(crimedata)

# > summary(crimedata)
# ID             Case.Number                          Date                          Block        
# Min.   :     634   HJ590004:      6   01/01/2008 12:01:00 AM:    286   100XX W OHARE ST    :  14666  
# 1st Qu.: 3259496   HZ140230:      6   01/01/2007 12:01:00 AM:    236   001XX N STATE ST    :  10338  
# Median : 5759322   HP296582:      5   01/01/2006 12:01:00 AM:    220   076XX S CICERO AVE  :   8731  
# Mean   : 5801173   HS256531:      5   01/01/2004 12:00:00 AM:    211   008XX N MICHIGAN AVE:   7301  
# 3rd Qu.: 8213548           :      4   01/01/2003 12:01:00 AM:    209   0000X N STATE ST    :   7054  
# Max.   :10758142   HJ104730:      4   01/01/2005 12:01:00 AM:    202   023XX S STATE ST    :   5199  
# (Other) :6209037   (Other)               :6207703   (Other)             :6155778  
# IUCR                  Primary.Type                      Description     
# 0820   : 497839   THEFT          :1289181   SIMPLE                 : 737955  
# 0460   : 470764   BATTERY        :1133704   $500 AND UNDER         : 497824  
# 0486   : 469353   CRIMINAL DAMAGE: 714477   DOMESTIC BATTERY SIMPLE: 469353  
# 1320   : 335870   NARCOTICS      : 685627   TO VEHICLE             : 346046  
# 1310   : 327930   OTHER OFFENSE  : 384044   TO PROPERTY            : 327930  
# 0810   : 317853   ASSAULT        : 379222   OVER $500              : 317840  
# (Other):3789458   (Other)        :1622812   (Other)                :3512119  
# Location.Description   Arrest         Domestic            Beat         District    
# STREET                        :1651738   false:4445043   false:5410230   Min.   : 111   Min.   : 1.00  
# RESIDENCE                     :1049602   true :1764024   true : 798837   1st Qu.: 623   1st Qu.: 6.00  
# APARTMENT                     : 629289                                   Median :1111   Median :10.00  
# SIDEWALK                      : 623262                                   Mean   :1196   Mean   :11.31  
# OTHER                         : 233925                                   3rd Qu.:1732   3rd Qu.:17.00  
# PARKING LOT/GARAGE(NON.RESID.): 177720                                   Max.   :2535   Max.   :31.00  
# (Other)                       :1843531                                                  NA's   :49     
# Ward        Community.Area      FBI.Code        X.Coordinate      Y.Coordinate          Year     
# Min.   : 1.0     Min.   : 0.0     06     :1289181   Min.   :      0   Min.   :      0   Min.   :2001  
# 1st Qu.:10.0     1st Qu.:23.0     08B    : 970344   1st Qu.:1152910   1st Qu.:1859142   1st Qu.:2004  
# Median :22.0     Median :32.0     14     : 714477   Median :1165917   Median :1890202   Median :2007  
# Mean   :22.6     Mean   :37.7     18     : 642143   Mean   :1164473   Mean   :1885628   Mean   :2008  
# 3rd Qu.:34.0     3rd Qu.:58.0     26     : 638595   3rd Qu.:1176341   3rd Qu.:1909355   3rd Qu.:2011  
# Max.   :50.0     Max.   :77.0     05     : 362646   Max.   :1205119   Max.   :1951622   Max.   :2016  
# NA's   :614864   NA's   :616051   (Other):1591681   NA's   :70319     NA's   :70319                   
# Updated.On         Latitude       Longitude                               Location      
# 04/15/2016 08:55:02 AM:2738834   Min.   :36.62   Min.   :-91.69                                :  70319  
# 02/04/2016 06:33:39 AM:2435992   1st Qu.:41.77   1st Qu.:-87.71   (41.976290414, -87.905227221):  12533  
# 08/17/2015 03:03:40 PM: 686650   Median :41.85   Median :-87.67   (41.754592961, -87.741528537):   8930  
# 04/15/2016 03:49:27 PM:   7862   Mean   :41.84   Mean   :-87.67   (41.883500187, -87.627876698):   5920  
# 09/10/2015 11:43:14 AM:   6494   3rd Qu.:41.91   3rd Qu.:-87.63   (41.897895128, -87.624096605):   3724  
# 10/09/2015 03:58:54 PM:   6053   Max.   :42.02   Max.   :-87.52   (41.896888586, -87.628203192):   2915  
# (Other)               : 327182   NA's   :70319   NA's   :70319    (Other)                      :6104726  
# 
# 

# selecting district,crime primary type into new crimedistrict dataset
crimedistrict <- crimedata[c("District","Primary.Type")]

#> crimedistrict <- crimedata[c("District","Primary.Type")]

#summary of crimedistrict dataframe
summary(crimedistrict)

# District              Primary.Type    
# Min.   : 1.00   THEFT          :1289181  
# 1st Qu.: 6.00   BATTERY        :1133704  
# Median :10.00   CRIMINAL DAMAGE: 714477  
# Mean   :11.31   NARCOTICS      : 685627  
# 3rd Qu.:17.00   OTHER OFFENSE  : 384044  
# Max.   :31.00   ASSAULT        : 379222  
# NA's   :49      (Other)        :1622812  

# summary of count of each crime type
summary(crimedistrict$Primary.Type)
# ARSON                           ASSAULT 
# 10334                            379222 
# BATTERY                          BURGLARY 
# 1133704                            362646 
# CONCEALED CARRY LICENSE VIOLATION               CRIM SEXUAL ASSAULT 
# 80                             23606 
# CRIMINAL DAMAGE                 CRIMINAL TRESPASS 
# 714477                            179747 
# DECEPTIVE PRACTICE                 DOMESTIC VIOLENCE 
# 221942                                 1 
# GAMBLING                          HOMICIDE 
# 14033                              8117 
# HUMAN TRAFFICKING  INTERFERENCE WITH PUBLIC OFFICER 
# 28                             12785 
# INTIMIDATION                        KIDNAPPING 
# 3616                              6315 
# LIQUOR LAW VIOLATION               MOTOR VEHICLE THEFT 
# 13607                            292690 
# NARCOTICS                      NON-CRIMINAL 
# 685627                                89 
# NON-CRIMINAL (SUBJECT SPECIFIED)                    NON - CRIMINAL 
# 4                                38 
# OBSCENITY        OFFENSE INVOLVING CHILDREN 
# 404                             40417 
# OTHER NARCOTIC VIOLATION                     OTHER OFFENSE 
# 111                            384044 
# PROSTITUTION                  PUBLIC INDECENCY 
# 66900                               140 
# PUBLIC PEACE VIOLATION                         RITUALISM 
# 44948                                23 
# ROBBERY                       SEX OFFENSE 
# 233595                             22813 
# STALKING                             THEFT 
# 2972                           1289181 
# WEAPONS VIOLATION 
# 60811 



#remove NA values in district for data cleaning
crimedistrict<- crimedistrict[!is.na(crimedistrict$District),]

summary(crimedistrict)
# District              Primary.Type    
# Min.   : 1.00   THEFT          :1289175  
# 1st Qu.: 6.00   BATTERY        :1133699  
# Median :10.00   CRIMINAL DAMAGE: 714473  
# Mean   :11.31   NARCOTICS      : 685625  
# 3rd Qu.:17.00   OTHER OFFENSE  : 384042  
# Max.   :31.00   ASSAULT        : 379218  
# (Other)        :1622786  

# get district and count of crimes in each district
table(crimedistrict$District)
# 
# 1      2      3      4      5      6      7      8      9     10     11     12     13 
# 228132 301469 318034 353491 275308 355691 370640 425849 311413 263376 394246 303605      1 
# 14     15     16     17     18     19     20     21     22     23     24     25     31 
# 246581 273983 205445 180032 265516 276618 108135      4 204202      1 185332 361793    121 

#move the required district,count to another dataset
#districtcrimecount<- table(crimedistrict$District)
View(districtcrimecount)
districtcrimecount<- as.data.frame(table(crimedistrict$District))

#To plot district,crime count using barplot
#Converting of exponential values to numerical,we used scipen
options(scipen = 999)
barplot(table(crimedistrict$District),main="District - Crime count Distribution", 
          +         xlab="Districts" , ylab= "total number of crimes", names.arg=c())


##Get month from date field
crimeMonth<-crimedata[c("Date","Primary.Type","Location.Description")]

##TO CONVERT OUR DATE TO REQUIRED FORMAT
install.packages("lubridate")
library("lubridate")
crimeMonth$Date<-mdy_hms(crimeMonth$Date)
 View(crimeMonth)
 crimeMonth$Date<-1 + as.POSIXlt(crimeMonth$Date)$mon
 
 ##Number of crime according to the day

 crimedata$Weekday <- weekdays(crimedata$Date)
 table(crimedata$Weekday)
 
# Friday    Monday  Saturday    Sunday  Thursday   Tuesday Wednesday 
# 935499    875173    886665    836691    887352    890945    896742 
 
#ggplot of crime per week
 WeekdayCounts <- as.data.frame(table(crimedata$Weekday))
 ggplot(WeekdayCounts, aes(x = Var1, y = Freq)) + geom_line((aes(group = 1))) + xlab("Day of the week") + ylab("Total crimes in city")

 #number of crimes per hour in a day
 table(crimedata$Weekday, crimedata$hour)WeekdayCounts$Var1 <- factor(WeekdayCounts$Var1, ordered = T, levels = c("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"))

 
# 0     1     2     3     4     5     6     7     8     9    10    11    12    13    14
# Friday    48236 25519 20956 16223 12229 10844 14355 22218 33112 41013 39736 41747 53816 44605 48175
 # Monday    48728 24239 19086 14751 11261 10488 13870 21858 33124 40956 38128 39366 51037 42707 45405
 # Saturday  55826 38773 35032 28352 20687 14277 12805 14755 21885 31426 34795 36831 46705 39020 40540
 # Sunday    55037 39916 36265 32301 23935 16671 12923 12958 18193 27075 30271 33022 41079 34875 36405
 # Thursday  46512 23892 19063 14808 11086 10044 14374 22430 34181 41146 38771 40817 52025 43813 47475
 # Tuesday   46471 22951 17767 13531 10399  9976 14196 23035 34150 41270 38492 40650 52498 44481 47825
 # Wednesday 46559 22973 17926 13660 10314  9975 14418 22725 34399 41688 39065 40836 53449 45158 48229
 
 # 15    16    17    18    19    20    21    22    23
 # Friday    51714 47525 48597 52178 53183 53051 53461 54834 48172
 # Monday    47723 44827 45599 49237 50763 49827 48658 46727 36808
 #Saturday  42303 41017 41817 45003 47265 48877 49594 51906 47174
 #Sunday    38816 38724 40000 43411 45952 47541 46783 46479 38059
 # Thursday  49488 45446 45466 48828 51114 50928 49386 47762 38497
 # Tuesday   49064 46060 46399 49959 52401 52715 50737 48429 37489
 # Wednesday 49904 46098 46733 50740 52881 52739 50427 48141 37705
 
 #Day hour count
 DayHourCount <- as.data.frame(table(crimedata$Weekday, crimedata$hour))
 str(DayHourCount)
# 'data.frame':	168 obs. of  3 variables:
# $ Var1: Factor w/ 7 levels "Friday","Monday",..: 1 2 3 4 5 6 7 1 2 3 ...
# $ Var2: Factor w/ 24 levels "0","1","2","3",..: 1 1 1 1 1 1 1 2 2 2 ...
# $ Freq: int  48236 48728 55826 55037 46512 46471 46559 25519 24239 38773 ..
 
 
 #plotting heat map
 ggplot(DayHourCount, aes(x = Hour, y = Var1)) + geom_tile(aes(fill = Freq)) + scale_fill_gradient(name = "Total Crime count", low = "white", high = "red") + theme(axis.title.y = element_blank())
 
 ##Monthly crime spread
MonthCrimeTypeCount <- as.data.frame(table(crimedata$Month, crimedata$Primary.Type))
View(MonthCrimeTypeCount)
write.csv(MonthCrimeTypeCount, file = "MonthCrimeTypeCount.csv")