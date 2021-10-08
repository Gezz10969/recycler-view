package com.bangkit.gessel.knowyourlanguage

object LanguageListData {
    val langNames = arrayOf("C",
        "C++",
        "C#",
        "Dart",
        "Go",
        "Java",
        "Kotlin",
        "Python",
        "R",
        "Swift")

    val designedNames = arrayOf("Dennis Ritchie",
            "Bjarne Stroustrup",
            "Microsoft",
            "Lars Bak and Kasper Lund",
            "Robert Griesemer, Rob Pike, Ken Thompson",
            "James Gosling",
            "JetBrains",
            "Guido van Rossum",
            "Ross Ihaka and Robert Gentleman",
            "Chris Lattner, Doug Gregor, John McCall, Ted Kremenek, Joe Groff, and Apple Inc.")

    val developerNames = arrayOf("Dennis Ritchie & Bell Labs",
        "ISO/IEC JTC1",
        "Microsoft",
        "Google",
        "The Go Authors",
        "Oracle Corporation",
        "JetBrains",
        "Python Software Foundation",
        "R Core Team",
        "Apple Inc.")

    private val releaseDate = arrayOf("1972",
            "1985",
            "2000",
            "October 10, 2011",
            "November 10, 2009",
            "May 23, 1995",
            "July 22, 2011",
            "1991",
            "August 1993",
            "June 2, 2014")

    private val extensionName = arrayOf(".c",
            ".cpp",
            ".cs",
            ".dart",
            ".go",
            ".java",
            ".kt",
            ".py",
            ".r",
            ".swift")

    private val paradigmList = arrayOf("Imperative (procedural), \nstructured",
            "Multi-paradigm: \n\tprocedural, \n\tfunctional, \n\tobject-oriented, \n\tgeneric, \n\tmodular",
            "Structured, \nimperative, \nobject-oriented, \nevent-driven, \ntask-driven, \nfunctional, \ngeneric, \nreflective, \nconcurrent",
            "Multi-paradigm: \n\tfunctional, \n\timperative, \n\tobject-oriented, \n\treflective",
            "Multi-paradigm: \n\tconcurrent, \n\tfunctional, \n\timperative, \n\tobject-oriented",
            "Multi-paradigm: \n\tgeneric, \n\tobject-oriented (class-based), \n\timperative, \n\treflective",
            "Multi-paradigm: \n\tobject-oriented, \n\tfunctional, \n\timperative, \n\tblock structured, \n\tdeclarative, \n\tgeneric, \n\treflective, \n\tconcurrent",
            "Multi-paradigm: \n\tfunctional, \n\timperative, \n\tobject-oriented, \n\tstructured, \n\treflective",
            "Multi-paradigm: \n\tArray, \n\tobject-oriented, \n\timperative, \n\tfunctional, \n\tprocedural, \n\treflective",
            "Multi-paradigm: \n\tprotocol-oriented, \n\tobject-oriented, \n\tfunctional, \n\timperative, \n\tblock structured, \n\tdeclarative")

    val langImages = intArrayOf(R.drawable.c_biasa,
        R.drawable.cpp,
        R.drawable.cs,
        R.drawable.dart,
        R.drawable.go,
        R.drawable.java,
        R.drawable.kotlin,
        R.drawable.python,
        R.drawable.r,
        R.drawable.swift)

    val listData: ArrayList<Language>
        get() {
            val list = arrayListOf<Language>()
            for (position in LanguageListData.langNames.indices) {
                val lang = Language()
                lang.name = LanguageListData.langNames[position]
                lang.developer = LanguageListData.developerNames[position]
                lang.designed = LanguageListData.designedNames[position]
                lang.release = LanguageListData.releaseDate[position]
                lang.extension = LanguageListData.extensionName[position]
                lang.paradigm = LanguageListData.paradigmList[position]
                lang.photo = langImages[position]
                list.add(lang)
            }
            return list
        }
}