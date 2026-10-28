package com.peregrine.quizmaster.data.repository

object QuizSampleData {
    // Keep these IDs identical to every question categoryId below and to Firestore category document IDs.
    val Categories = listOf(
        mapOf(
            "id" to "pakistan_studies",
            "name" to "Pakistan Studies",
            "description" to "Pakistan Movement, constitutional history, national milestones and political history",
            "isActive" to true,
            "order" to 1
        ),
        mapOf(
            "id" to "pakistan_geography",
            "name" to "Pakistan Geography",
            "description" to "Rivers, mountains, provinces, cities, dams, lakes and landmarks",
            "isActive" to true,
            "order" to 2
        ),
        mapOf(
            "id" to "islamiat",
            "name" to "Islamiat",
            "description" to "Core Islamic knowledge, practices, terminology and institutions in Pakistan",
            "isActive" to true,
            "order" to 3
        ),
        mapOf(
            "id" to "pakistan_general_knowledge",
            "name" to "Pakistan General Knowledge",
            "description" to "National symbols, institutions, dates and general facts about Pakistan",
            "isActive" to true,
            "order" to 4
        ),
        mapOf(
            "id" to "pakistan_culture",
            "name" to "Pakistani Culture & Heritage",
            "description" to "Languages, literature, food, festivals, crafts and heritage sites",
            "isActive" to true,
            "order" to 5
        ),
        mapOf(
            "id" to "pakistan_science_sports",
            "name" to "Science, Economy & Sports",
            "description" to "Pakistani science, industries, institutions, sports and economic basics",
            "isActive" to true,
            "order" to 6
        )
    )

    val CategoryIds = listOf("pakistan_studies", "pakistan_geography", "islamiat", "pakistan_general_knowledge", "pakistan_culture", "pakistan_science_sports")

    val Questions = listOf(
        mapOf(
            "id" to 41,
            "categoryId" to "pakistan_studies",
            "question" to "When did Pakistan become independent?",
            "options" to listOf("14 August 1947", "15 August 1947", "23 March 1940", "26 January 1950"),
            "correctAnswer" to "14 August 1947",
            "explanation" to "Pakistan became independent on 14 August 1947.",
            "isActive" to true,
            "order" to 11
        ),
        mapOf(
            "id" to 42,
            "categoryId" to "pakistan_studies",
            "question" to "Who is widely known as the founder of Pakistan?",
            "options" to listOf("Allama Iqbal", "Muhammad Ali Jinnah", "Liaquat Ali Khan", "Sir Syed Ahmad Khan"),
            "correctAnswer" to "Muhammad Ali Jinnah",
            "explanation" to "Muhammad Ali Jinnah led the Pakistan Movement and became the country’s first Governor-General.",
            "isActive" to true,
            "order" to 12
        ),
        mapOf(
            "id" to 43,
            "categoryId" to "pakistan_studies",
            "question" to "Who was Pakistan’s first Governor-General?",
            "options" to listOf("Liaquat Ali Khan", "Khawaja Nazimuddin", "Muhammad Ali Jinnah", "Iskander Mirza"),
            "correctAnswer" to "Muhammad Ali Jinnah",
            "explanation" to "Muhammad Ali Jinnah served as Pakistan’s first Governor-General.",
            "isActive" to true,
            "order" to 13
        ),
        mapOf(
            "id" to "q_44",
            "categoryId" to "pakistan_studies",
            "question" to "Who was Pakistan’s first Prime Minister?",
            "options" to listOf("Muhammad Ali Jinnah", "Liaquat Ali Khan", "Ayub Khan", "Zulfikar Ali Bhutto"),
            "correctAnswer" to "Liaquat Ali Khan",
            "explanation" to "Liaquat Ali Khan became Pakistan’s first Prime Minister in 1947.",
            "isActive" to true,
            "order" to 14
        ),
        mapOf(
            "id" to 45,
            "categoryId" to "pakistan_studies",
            "question" to "Which resolution was passed on 23 March 1940?",
            "options" to listOf("Objectives Resolution", "Lahore Resolution", "Delhi Resolution", "Pakistan Resolution of 1956"),
            "correctAnswer" to "Lahore Resolution",
            "explanation" to "The Lahore Resolution was adopted by the All-India Muslim League in 1940.",
            "isActive" to true,
            "order" to 15
        ),
        mapOf(
            "id" to "q_46",
            "categoryId" to "pakistan_studies",
            "question" to "Where was the Lahore Resolution passed?",
            "options" to listOf("Karachi", "Dhaka", "Lahore", "Peshawar"),
            "correctAnswer" to "Lahore",
            "explanation" to "It was passed at Minto Park, now called Greater Iqbal Park, in Lahore.",
            "isActive" to true,
            "order" to 16
        ),
        mapOf(
            "id" to 47,
            "categoryId" to "pakistan_studies",
            "question" to "Who presented the Lahore Resolution in 1940?",
            "options" to listOf("A. K. Fazlul Huq", "Liaquat Ali Khan", "Chaudhry Rehmat Ali", "Allama Iqbal"),
            "correctAnswer" to "A. K. Fazlul Huq",
            "explanation" to "A. K. Fazlul Huq, the premier of Bengal, moved the Lahore Resolution.",
            "isActive" to true,
            "order" to 17
        ),
        mapOf(
            "id" to 48,
            "categoryId" to "pakistan_studies",
            "question" to "Who gave the Allahabad Address in 1930?",
            "options" to listOf("Muhammad Ali Jinnah", "Allama Muhammad Iqbal", "Sir Syed Ahmad Khan", "Maulana Muhammad Ali Jauhar"),
            "correctAnswer" to "Allama Muhammad Iqbal",
            "explanation" to "Allama Iqbal delivered his presidential address at the Muslim League session in Allahabad in 1930.",
            "isActive" to true,
            "order" to 18
        ),
        mapOf(
            "id" to 49,
            "categoryId" to "pakistan_studies",
            "question" to "Who wrote the pamphlet “Now or Never” in 1933?",
            "options" to listOf("Chaudhry Rehmat Ali", "Allama Iqbal", "Liaquat Ali Khan", "Sir Syed Ahmad Khan"),
            "correctAnswer" to "Chaudhry Rehmat Ali",
            "explanation" to "Chaudhry Rehmat Ali used the name Pakistan in the 1933 pamphlet “Now or Never”.",
            "isActive" to true,
            "order" to 19
        ),
        mapOf(
            "id" to 50,
            "categoryId" to "pakistan_studies",
            "question" to "What was the first constitution of Pakistan enacted?",
            "options" to listOf("1956", "1962", "1973", "1949"),
            "correctAnswer" to "1956",
            "explanation" to "Pakistan’s first constitution came into force on 23 March 1956.",
            "isActive" to true,
            "order" to 20
        ),
        mapOf(
            "id" to 51,
            "categoryId" to "pakistan_studies",
            "question" to "When did Pakistan become an Islamic Republic under its first constitution?",
            "options" to listOf("14 August 1947", "23 March 1956", "8 June 1962", "14 August 1973"),
            "correctAnswer" to "23 March 1956",
            "explanation" to "The 1956 Constitution named the country the Islamic Republic of Pakistan.",
            "isActive" to true,
            "order" to 21
        ),
        mapOf(
            "id" to 52,
            "categoryId" to "pakistan_studies",
            "question" to "Which constitution is currently in force in Pakistan, as amended?",
            "options" to listOf("1956 Constitution", "1962 Constitution", "1973 Constitution", "1947 Independence Act"),
            "correctAnswer" to "1973 Constitution",
            "explanation" to "Pakistan’s current constitutional framework is based on the Constitution of 1973, as amended.",
            "isActive" to true,
            "order" to 22
        ),
        mapOf(
            "id" to 53,
            "categoryId" to "pakistan_studies",
            "question" to "Who was Pakistan’s first President?",
            "options" to listOf("Ayub Khan", "Iskander Mirza", "Yahya Khan", "Fazal Ilahi Chaudhry"),
            "correctAnswer" to "Iskander Mirza",
            "explanation" to "Iskander Mirza became Pakistan’s first President in 1956.",
            "isActive" to true,
            "order" to 23
        ),
        mapOf(
            "id" to 54,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the first woman Prime Minister of Pakistan?",
            "options" to listOf("Fatima Jinnah", "Benazir Bhutto", "Hina Rabbani Khar", "Begum Ra’ana Liaquat Ali Khan"),
            "correctAnswer" to "Benazir Bhutto",
            "explanation" to "Benazir Bhutto became Prime Minister in 1988 and was the first woman to lead a government in a Muslim-majority country in modern times.",
            "isActive" to true,
            "order" to 24
        ),
        mapOf(
            "id" to 55,
            "categoryId" to "pakistan_studies",
            "question" to "Which leader is known as Quaid-e-Azam?",
            "options" to listOf("Allama Iqbal", "Muhammad Ali Jinnah", "Liaquat Ali Khan", "Sir Syed Ahmad Khan"),
            "correctAnswer" to "Muhammad Ali Jinnah",
            "explanation" to "Quaid-e-Azam, meaning Great Leader, is the honorific title of Muhammad Ali Jinnah.",
            "isActive" to true,
            "order" to 25
        ),
        mapOf(
            "id" to 56,
            "categoryId" to "pakistan_studies",
            "question" to "Which leader is commonly called Shaheed-e-Millat?",
            "options" to listOf("Liaquat Ali Khan", "Zulfikar Ali Bhutto", "Abdul Qadeer Khan", "Ayub Khan"),
            "correctAnswer" to "Liaquat Ali Khan",
            "explanation" to "Liaquat Ali Khan is known as Shaheed-e-Millat.",
            "isActive" to true,
            "order" to 26
        ),
        mapOf(
            "id" to 57,
            "categoryId" to "pakistan_studies",
            "question" to "When was the Objectives Resolution adopted by Pakistan’s Constituent Assembly?",
            "options" to listOf("12 March 1949", "23 March 1940", "14 August 1947", "23 March 1956"),
            "correctAnswer" to "12 March 1949",
            "explanation" to "The Constituent Assembly adopted the Objectives Resolution on 12 March 1949.",
            "isActive" to true,
            "order" to 27
        ),
        mapOf(
            "id" to 58,
            "categoryId" to "pakistan_studies",
            "question" to "Who moved the Objectives Resolution?",
            "options" to listOf("Liaquat Ali Khan", "Muhammad Ali Jinnah", "Khawaja Nazimuddin", "Chaudhry Muhammad Ali"),
            "correctAnswer" to "Liaquat Ali Khan",
            "explanation" to "Prime Minister Liaquat Ali Khan moved the Objectives Resolution.",
            "isActive" to true,
            "order" to 28
        ),
        mapOf(
            "id" to 59,
            "categoryId" to "pakistan_studies",
            "question" to "Which movement called for the restoration of democracy in Pakistan in the 1980s?",
            "options" to listOf("Pakistan Movement", "Movement for Restoration of Democracy", "Khilafat Movement", "Swadeshi Movement"),
            "correctAnswer" to "Movement for Restoration of Democracy",
            "explanation" to "The Movement for Restoration of Democracy, or MRD, opposed military rule in the 1980s.",
            "isActive" to true,
            "order" to 29
        ),
        mapOf(
            "id" to 60,
            "categoryId" to "pakistan_studies",
            "question" to "In which year did East Pakistan become the independent state of Bangladesh?",
            "options" to listOf("1965", "1971", "1973", "1947"),
            "correctAnswer" to "1971",
            "explanation" to "Bangladesh emerged as an independent country in 1971.",
            "isActive" to true,
            "order" to 30
        ),
        mapOf(
            "id" to 61,
            "categoryId" to "pakistan_geography",
            "question" to "What is the capital city of Pakistan?",
            "options" to listOf("Karachi", "Lahore", "Islamabad", "Quetta"),
            "correctAnswer" to "Islamabad",
            "explanation" to "Islamabad is Pakistan’s national capital.",
            "isActive" to true,
            "order" to 31
        ),
        mapOf(
            "id" to 62,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the largest city in Pakistan by population?",
            "options" to listOf("Islamabad", "Karachi", "Peshawar", "Quetta"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi is Pakistan’s largest city by population.",
            "isActive" to true,
            "order" to 32
        ),
        mapOf(
            "id" to 63,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the longest river in Pakistan?",
            "options" to listOf("Jhelum", "Chenab", "Ravi", "Indus"),
            "correctAnswer" to "Indus",
            "explanation" to "The Indus River is the longest river in Pakistan.",
            "isActive" to true,
            "order" to 33
        ),
        mapOf(
            "id" to 64,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the highest mountain in Pakistan?",
            "options" to listOf("Nanga Parbat", "K2", "Broad Peak", "Rakaposhi"),
            "correctAnswer" to "K2",
            "explanation" to "K2, at about 8,611 metres, is Pakistan’s highest mountain.",
            "isActive" to true,
            "order" to 34
        ),
        mapOf(
            "id" to 65,
            "categoryId" to "pakistan_geography",
            "question" to "K2 is part of which mountain range?",
            "options" to listOf("Himalayas", "Hindu Kush", "Karakoram", "Salt Range"),
            "correctAnswer" to "Karakoram",
            "explanation" to "K2 lies in the Karakoram range.",
            "isActive" to true,
            "order" to 35
        ),
        mapOf(
            "id" to 66,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the largest province of Pakistan by area?",
            "options" to listOf("Punjab", "Sindh", "Khyber Pakhtunkhwa", "Balochistan"),
            "correctAnswer" to "Balochistan",
            "explanation" to "Balochistan is Pakistan’s largest province by land area.",
            "isActive" to true,
            "order" to 36
        ),
        mapOf(
            "id" to 67,
            "categoryId" to "pakistan_geography",
            "question" to "Which province has the largest population?",
            "options" to listOf("Sindh", "Punjab", "Balochistan", "Khyber Pakhtunkhwa"),
            "correctAnswer" to "Punjab",
            "explanation" to "Punjab is Pakistan’s most populous province.",
            "isActive" to true,
            "order" to 37
        ),
        mapOf(
            "id" to 68,
            "categoryId" to "pakistan_geography",
            "question" to "Which sea lies to the south of Pakistan?",
            "options" to listOf("Red Sea", "Arabian Sea", "Caspian Sea", "Black Sea"),
            "correctAnswer" to "Arabian Sea",
            "explanation" to "Pakistan’s southern coastline borders the Arabian Sea.",
            "isActive" to true,
            "order" to 38
        ),
        mapOf(
            "id" to 69,
            "categoryId" to "pakistan_geography",
            "question" to "Which desert is mainly located in southeastern Pakistan?",
            "options" to listOf("Thar Desert", "Sahara Desert", "Gobi Desert", "Kalahari Desert"),
            "correctAnswer" to "Thar Desert",
            "explanation" to "The Thar Desert extends across southeastern Pakistan and western India.",
            "isActive" to true,
            "order" to 39
        ),
        mapOf(
            "id" to 70,
            "categoryId" to "pakistan_geography",
            "question" to "Which Pakistani city is famous for the Khyber Pass route?",
            "options" to listOf("Karachi", "Peshawar", "Hyderabad", "Multan"),
            "correctAnswer" to "Peshawar",
            "explanation" to "The historic Khyber Pass connects the Peshawar region with Afghanistan.",
            "isActive" to true,
            "order" to 40
        ),
        mapOf(
            "id" to 71,
            "categoryId" to "pakistan_geography",
            "question" to "Which lake is one of Pakistan’s largest natural lakes?",
            "options" to listOf("Saif-ul-Malook", "Manchar Lake", "Attabad Lake", "Hanna Lake"),
            "correctAnswer" to "Manchar Lake",
            "explanation" to "Manchar Lake in Sindh is one of South Asia’s largest lakes.",
            "isActive" to true,
            "order" to 41
        ),
        mapOf(
            "id" to 72,
            "categoryId" to "pakistan_geography",
            "question" to "Which pass connects Pakistan with China through the Karakoram Highway?",
            "options" to listOf("Bolan Pass", "Lowari Pass", "Khunjerab Pass", "Khyber Pass"),
            "correctAnswer" to "Khunjerab Pass",
            "explanation" to "The Karakoram Highway crosses the Khunjerab Pass at the Pakistan–China border.",
            "isActive" to true,
            "order" to 42
        ),
        mapOf(
            "id" to 73,
            "categoryId" to "pakistan_geography",
            "question" to "Which city is often called the “City of Saints”?",
            "options" to listOf("Multan", "Faisalabad", "Sialkot", "Gwadar"),
            "correctAnswer" to "Multan",
            "explanation" to "Multan is widely known as the City of Saints because of its many Sufi shrines.",
            "isActive" to true,
            "order" to 43
        ),
        mapOf(
            "id" to 74,
            "categoryId" to "pakistan_geography",
            "question" to "Which city is known as Pakistan’s “Manchester” because of its textile industry?",
            "options" to listOf("Faisalabad", "Quetta", "Gilgit", "Sukkur"),
            "correctAnswer" to "Faisalabad",
            "explanation" to "Faisalabad is a major textile and manufacturing centre.",
            "isActive" to true,
            "order" to 44
        ),
        mapOf(
            "id" to 75,
            "categoryId" to "pakistan_geography",
            "question" to "Which port city is located in Balochistan on the Arabian Sea?",
            "options" to listOf("Gwadar", "Sialkot", "Mardan", "Bahawalpur"),
            "correctAnswer" to "Gwadar",
            "explanation" to "Gwadar is a deep-sea port on Balochistan’s coast.",
            "isActive" to true,
            "order" to 45
        ),
        mapOf(
            "id" to 76,
            "categoryId" to "pakistan_geography",
            "question" to "Which river flows past the city of Hyderabad in Sindh region?",
            "options" to listOf("Indus", "Ravi", "Swat", "Kabul"),
            "correctAnswer" to "Indus",
            "explanation" to "Hyderabad in Sindh lies near the Indus River.",
            "isActive" to true,
            "order" to 46
        ),
        mapOf(
            "id" to 77,
            "categoryId" to "pakistan_geography",
            "question" to "Which province is home to the Swat Valley?",
            "options" to listOf("Sindh", "Punjab", "Khyber Pakhtunkhwa", "Balochistan"),
            "correctAnswer" to "Khyber Pakhtunkhwa",
            "explanation" to "Swat Valley is located in Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 47
        ),
        mapOf(
            "id" to 78,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the federal territory that contains Pakistan’s capital?",
            "options" to listOf("Islamabad Capital Territory", "Gilgit-Baltistan", "Azad Jammu and Kashmir", "Federally Administered Tribal Areas"),
            "correctAnswer" to "Islamabad Capital Territory",
            "explanation" to "Islamabad is administered as the Islamabad Capital Territory.",
            "isActive" to true,
            "order" to 48
        ),
        mapOf(
            "id" to 79,
            "categoryId" to "pakistan_geography",
            "question" to "Which dam is built on the Indus River near the boundary of Khyber Pakhtunkhwa and Punjab?",
            "options" to listOf("Tarbela Dam", "Hub Dam", "Rawal Dam", "Khanpur Dam"),
            "correctAnswer" to "Tarbela Dam",
            "explanation" to "Tarbela Dam is built on the Indus River in Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 49
        ),
        mapOf(
            "id" to 80,
            "categoryId" to "pakistan_geography",
            "question" to "Which major dam is built on the Jhelum River?",
            "options" to listOf("Mangla Dam", "Tarbela Dam", "Warsak Dam", "Mirani Dam"),
            "correctAnswer" to "Mangla Dam",
            "explanation" to "Mangla Dam is built on the Jhelum River near Mirpur.",
            "isActive" to true,
            "order" to 50
        ),
        mapOf(
            "id" to 81,
            "categoryId" to "pakistan_geography",
            "question" to "Which Pakistani region is famous for the Deosai Plains?",
            "options" to listOf("Gilgit-Baltistan", "Sindh", "Punjab", "Balochistan"),
            "correctAnswer" to "Gilgit-Baltistan",
            "explanation" to "The Deosai Plains are a high-altitude plateau in Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 51
        ),
        mapOf(
            "id" to 82,
            "categoryId" to "islamiat",
            "question" to "What is the holy book of Islam?",
            "options" to listOf("Torah", "Bible", "Quran", "Zabur"),
            "correctAnswer" to "Quran",
            "explanation" to "The Quran is the central holy scripture of Islam.",
            "isActive" to true,
            "order" to 52
        ),
        mapOf(
            "id" to 83,
            "categoryId" to "islamiat",
            "question" to "How many pillars of Islam are commonly taught?",
            "options" to listOf("Three", "Four", "Five", "Six"),
            "correctAnswer" to "Five",
            "explanation" to "The five pillars are Shahadah, Salah, Zakat, Sawm, and Hajj.",
            "isActive" to true,
            "order" to 53
        ),
        mapOf(
            "id" to 84,
            "categoryId" to "islamiat",
            "question" to "How many obligatory prayers are performed daily in Islam?",
            "options" to listOf("Three", "Four", "Five", "Seven"),
            "correctAnswer" to "Five",
            "explanation" to "Muslims are obligated to perform five daily prayers.",
            "isActive" to true,
            "order" to 54
        ),
        mapOf(
            "id" to 85,
            "categoryId" to "islamiat",
            "question" to "In which month do Muslims fast?",
            "options" to listOf("Muharram", "Ramadan", "Shawwal", "Rajab"),
            "correctAnswer" to "Ramadan",
            "explanation" to "Fasting during Ramadan is one of the five pillars of Islam.",
            "isActive" to true,
            "order" to 55
        ),
        mapOf(
            "id" to 86,
            "categoryId" to "islamiat",
            "question" to "Which city is the destination of Hajj?",
            "options" to listOf("Madinah", "Makkah", "Jerusalem", "Taif"),
            "correctAnswer" to "Makkah",
            "explanation" to "Hajj is performed in and around Makkah in Saudi Arabia.",
            "isActive" to true,
            "order" to 56
        ),
        mapOf(
            "id" to 87,
            "categoryId" to "islamiat",
            "question" to "What is the direction Muslims face during Salah called?",
            "options" to listOf("Mihrab", "Qiblah", "Minbar", "Ihram"),
            "correctAnswer" to "Qiblah",
            "explanation" to "The Qiblah is the direction toward the Kaaba in Makkah.",
            "isActive" to true,
            "order" to 57
        ),
        mapOf(
            "id" to 88,
            "categoryId" to "islamiat",
            "question" to "Which angel brought revelations to Prophet Muhammad (peace be upon him)?",
            "options" to listOf("Mikail", "Israfil", "Jibril", "Izrail"),
            "correctAnswer" to "Jibril",
            "explanation" to "Angel Jibril delivered Allah’s revelations to Prophet Muhammad (peace be upon him).",
            "isActive" to true,
            "order" to 58
        ),
        mapOf(
            "id" to 89,
            "categoryId" to "islamiat",
            "question" to "What is the migration from Makkah to Madinah known as?",
            "options" to listOf("Isra", "Hijrah", "Hajj", "Umrah"),
            "correctAnswer" to "Hijrah",
            "explanation" to "The Hijrah refers to Prophet Muhammad’s migration from Makkah to Madinah in 622 CE.",
            "isActive" to true,
            "order" to 59
        ),
        mapOf(
            "id" to 90,
            "categoryId" to "islamiat",
            "question" to "Which month begins the Islamic lunar calendar?",
            "options" to listOf("Ramadan", "Safar", "Muharram", "Dhul Hijjah"),
            "correctAnswer" to "Muharram",
            "explanation" to "Muharram is the first month of the Islamic calendar.",
            "isActive" to true,
            "order" to 60
        ),
        mapOf(
            "id" to 91,
            "categoryId" to "islamiat",
            "question" to "What is Zakat?",
            "options" to listOf("A pilgrimage", "Obligatory almsgiving", "A daily prayer", "A fasting meal"),
            "correctAnswer" to "Obligatory almsgiving",
            "explanation" to "Zakat is obligatory charity for eligible Muslims who meet the required conditions.",
            "isActive" to true,
            "order" to 61
        ),
        mapOf(
            "id" to 92,
            "categoryId" to "islamiat",
            "question" to "Which city contains Al-Masjid an-Nabawi?",
            "options" to listOf("Makkah", "Madinah", "Jerusalem", "Cairo"),
            "correctAnswer" to "Madinah",
            "explanation" to "Al-Masjid an-Nabawi, the Prophet’s Mosque, is in Madinah.",
            "isActive" to true,
            "order" to 62
        ),
        mapOf(
            "id" to 93,
            "categoryId" to "islamiat",
            "question" to "Which is the first surah of the Quran?",
            "options" to listOf("Al-Baqarah", "Al-Fatiha", "Al-Ikhlas", "An-Nas"),
            "correctAnswer" to "Al-Fatiha",
            "explanation" to "Surah Al-Fatiha appears first in the standard arrangement of the Quran.",
            "isActive" to true,
            "order" to 63
        ),
        mapOf(
            "id" to 94,
            "categoryId" to "islamiat",
            "question" to "How many surahs are in the Quran?",
            "options" to listOf("110", "112", "114", "116"),
            "correctAnswer" to "114",
            "explanation" to "The Quran contains 114 surahs.",
            "isActive" to true,
            "order" to 64
        ),
        mapOf(
            "id" to 95,
            "categoryId" to "islamiat",
            "question" to "Which prophet is associated with building the Kaaba with his son Ismail, according to Islamic tradition?",
            "options" to listOf("Musa", "Ibrahim", "Yusuf", "Yunus"),
            "correctAnswer" to "Ibrahim",
            "explanation" to "Islamic tradition says Prophet Ibrahim and his son Ismail raised the foundations of the Kaaba.",
            "isActive" to true,
            "order" to 65
        ),
        mapOf(
            "id" to 96,
            "categoryId" to "islamiat",
            "question" to "What is the night journey of Prophet Muhammad known as?",
            "options" to listOf("Hijrah", "Isra and Mi’raj", "Battle of Badr", "Farewell Pilgrimage"),
            "correctAnswer" to "Isra and Mi’raj",
            "explanation" to "Isra and Mi’raj refers to the Prophet’s night journey and ascension.",
            "isActive" to true,
            "order" to 66
        ),
        mapOf(
            "id" to 97,
            "categoryId" to "islamiat",
            "question" to "Which battle was the first major battle between Muslims and Quraysh?",
            "options" to listOf("Uhud", "Khandaq", "Badr", "Hunayn"),
            "correctAnswer" to "Badr",
            "explanation" to "The Battle of Badr took place in 624 CE.",
            "isActive" to true,
            "order" to 67
        ),
        mapOf(
            "id" to 98,
            "categoryId" to "islamiat",
            "question" to "What is the call to prayer called?",
            "options" to listOf("Iqamah", "Adhan", "Khutbah", "Tasbih"),
            "correctAnswer" to "Adhan",
            "explanation" to "The Adhan is the call announcing the time for prayer.",
            "isActive" to true,
            "order" to 68
        ),
        mapOf(
            "id" to 99,
            "categoryId" to "islamiat",
            "question" to "Which Eid follows the month of Ramadan?",
            "options" to listOf("Eid al-Adha", "Eid al-Fitr", "Ashura", "Mawlid"),
            "correctAnswer" to "Eid al-Fitr",
            "explanation" to "Eid al-Fitr marks the end of Ramadan.",
            "isActive" to true,
            "order" to 69
        ),
        mapOf(
            "id" to 100,
            "categoryId" to "islamiat",
            "question" to "Which Eid is celebrated during the Hajj season?",
            "options" to listOf("Eid al-Fitr", "Eid al-Adha", "Shab-e-Barat", "Ashura"),
            "correctAnswer" to "Eid al-Adha",
            "explanation" to "Eid al-Adha falls on 10 Dhul Hijjah, during the Hajj season.",
            "isActive" to true,
            "order" to 70
        ),
        mapOf(
            "id" to 101,
            "categoryId" to "islamiat",
            "question" to "What is the Islamic term for the declaration of faith?",
            "options" to listOf("Sawm", "Shahadah", "Zakat", "Tawaf"),
            "correctAnswer" to "Shahadah",
            "explanation" to "The Shahadah is the declaration of faith and the first pillar of Islam.",
            "isActive" to true,
            "order" to 71
        ),
        mapOf(
            "id" to 102,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the national language of Pakistan?",
            "options" to listOf("Punjabi", "Urdu", "English", "Sindhi"),
            "correctAnswer" to "Urdu",
            "explanation" to "Urdu is Pakistan’s national language; English is also used for official purposes.",
            "isActive" to true,
            "order" to 72
        ),
        mapOf(
            "id" to 103,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the currency of Pakistan?",
            "options" to listOf("Rupee", "Taka", "Riyal", "Dinar"),
            "correctAnswer" to "Rupee",
            "explanation" to "Pakistan’s currency is the Pakistani rupee (PKR).",
            "isActive" to true,
            "order" to 73
        ),
        mapOf(
            "id" to 104,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the international calling code for Pakistan?",
            "options" to listOf("+91", "+92", "+93", "+94"),
            "correctAnswer" to "+92",
            "explanation" to "Pakistan’s international telephone calling code is +92.",
            "isActive" to true,
            "order" to 74
        ),
        mapOf(
            "id" to 105,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the internet country-code top-level domain for Pakistan?",
            "options" to listOf(".pk", ".pa", ".ps", ".pi"),
            "correctAnswer" to ".pk",
            "explanation" to "Pakistan’s country-code top-level domain is .pk.",
            "isActive" to true,
            "order" to 75
        ),
        mapOf(
            "id" to 106,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which is Pakistan’s national animal?",
            "options" to listOf("Snow leopard", "Markhor", "Lion", "Chinkara"),
            "correctAnswer" to "Markhor",
            "explanation" to "The markhor is Pakistan’s national animal.",
            "isActive" to true,
            "order" to 76
        ),
        mapOf(
            "id" to 107,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which is Pakistan’s national bird?",
            "options" to listOf("Chukar partridge", "Peacock", "Falcon", "Himalayan monal"),
            "correctAnswer" to "Chukar partridge",
            "explanation" to "The chukar partridge is Pakistan’s national bird.",
            "isActive" to true,
            "order" to 77
        ),
        mapOf(
            "id" to 108,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which is Pakistan’s national flower?",
            "options" to listOf("Rose", "Jasmine", "Tulip", "Sunflower"),
            "correctAnswer" to "Jasmine",
            "explanation" to "Jasmine, locally called chambeli, is Pakistan’s national flower.",
            "isActive" to true,
            "order" to 78
        ),
        mapOf(
            "id" to 109,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which tree is Pakistan’s national tree?",
            "options" to listOf("Deodar cedar", "Neem", "Banyan", "Date palm"),
            "correctAnswer" to "Deodar cedar",
            "explanation" to "The deodar cedar is recognised as Pakistan’s national tree.",
            "isActive" to true,
            "order" to 79
        ),
        mapOf(
            "id" to 110,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which sport is Pakistan especially known for internationally?",
            "options" to listOf("Cricket", "Ice hockey", "Baseball", "Rugby league"),
            "correctAnswer" to "Cricket",
            "explanation" to "Cricket is among Pakistan’s most popular and internationally followed sports.",
            "isActive" to true,
            "order" to 80
        ),
        mapOf(
            "id" to 111,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani won the Nobel Prize in Physics in 1979?",
            "options" to listOf("Abdus Salam", "Abdul Qadeer Khan", "Pervez Hoodbhoy", "Salimuzzaman Siddiqui"),
            "correctAnswer" to "Abdus Salam",
            "explanation" to "Physicist Abdus Salam shared the 1979 Nobel Prize in Physics.",
            "isActive" to true,
            "order" to 81
        ),
        mapOf(
            "id" to 112,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Who was the first Pakistani to win a Nobel Prize?",
            "options" to listOf("Malala Yousafzai", "Abdus Salam", "Abdul Sattar Edhi", "Sharmeen Obaid-Chinoy"),
            "correctAnswer" to "Abdus Salam",
            "explanation" to "Abdus Salam won the Nobel Prize in Physics in 1979.",
            "isActive" to true,
            "order" to 82
        ),
        mapOf(
            "id" to 113,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Malala Yousafzai received the Nobel Peace Prize in which year?",
            "options" to listOf("2011", "2012", "2014", "2016"),
            "correctAnswer" to "2014",
            "explanation" to "Malala Yousafzai shared the Nobel Peace Prize in 2014.",
            "isActive" to true,
            "order" to 83
        ),
        mapOf(
            "id" to 114,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani city is famous for producing surgical instruments?",
            "options" to listOf("Sialkot", "Gwadar", "Skardu", "Larkana"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot is known internationally for its sports goods and surgical instruments.",
            "isActive" to true,
            "order" to 84
        ),
        mapOf(
            "id" to 115,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which institution is responsible for Pakistan’s central banking?",
            "options" to listOf("National Bank of Pakistan", "State Bank of Pakistan", "Securities and Exchange Commission", "Federal Board of Revenue"),
            "correctAnswer" to "State Bank of Pakistan",
            "explanation" to "The State Bank of Pakistan is the country’s central bank.",
            "isActive" to true,
            "order" to 85
        ),
        mapOf(
            "id" to 116,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the name of Pakistan’s national parliament’s lower house?",
            "options" to listOf("Senate", "National Assembly", "Supreme Court", "Council of Common Interests"),
            "correctAnswer" to "National Assembly",
            "explanation" to "Pakistan’s Parliament includes the National Assembly and the Senate.",
            "isActive" to true,
            "order" to 86
        ),
        mapOf(
            "id" to 117,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the upper house of Pakistan’s Parliament called?",
            "options" to listOf("National Assembly", "Senate", "Cabinet", "Provincial Assembly"),
            "correctAnswer" to "Senate",
            "explanation" to "The Senate is the upper house of Pakistan’s Parliament.",
            "isActive" to true,
            "order" to 87
        ),
        mapOf(
            "id" to 118,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani organisation manages the national identity-card system?",
            "options" to listOf("NADRA", "FBR", "NEPRA", "PEMRA"),
            "correctAnswer" to "NADRA",
            "explanation" to "NADRA manages national identity registration and related records.",
            "isActive" to true,
            "order" to 88
        ),
        mapOf(
            "id" to 119,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which organisation conducts Pakistan’s population census and official statistics?",
            "options" to listOf("Pakistan Bureau of Statistics", "State Bank of Pakistan", "NADRA", "Election Commission of Pakistan"),
            "correctAnswer" to "Pakistan Bureau of Statistics",
            "explanation" to "The Pakistan Bureau of Statistics is the national agency for official statistics and census operations.",
            "isActive" to true,
            "order" to 89
        ),
        mapOf(
            "id" to 120,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the name of Pakistan’s national airline?",
            "options" to listOf("Airblue", "Pakistan International Airlines", "SereneAir", "Fly Jinnah"),
            "correctAnswer" to "Pakistan International Airlines",
            "explanation" to "Pakistan International Airlines is commonly known as PIA.",
            "isActive" to true,
            "order" to 90
        ),
        mapOf(
            "id" to 121,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani city is home to the Faisal Mosque?",
            "options" to listOf("Lahore", "Islamabad", "Karachi", "Quetta"),
            "correctAnswer" to "Islamabad",
            "explanation" to "The Faisal Mosque is located in Islamabad.",
            "isActive" to true,
            "order" to 91
        ),
        mapOf(
            "id" to 122,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which city is home to the Minar-e-Pakistan monument?",
            "options" to listOf("Islamabad", "Karachi", "Lahore", "Peshawar"),
            "correctAnswer" to "Lahore",
            "explanation" to "Minar-e-Pakistan stands in Greater Iqbal Park in Lahore.",
            "isActive" to true,
            "order" to 92
        ),
        mapOf(
            "id" to 123,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani city is associated with the ancient archaeological site of Mohenjo-daro nearby?",
            "options" to listOf("Larkana", "Murree", "Abbottabad", "Sargodha"),
            "correctAnswer" to "Larkana",
            "explanation" to "Mohenjo-daro is an ancient Indus Valley Civilization site near Larkana in Sindh.",
            "isActive" to true,
            "order" to 93
        ),
        mapOf(
            "id" to 124,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which ancient civilisation is associated with Harappa and Mohenjo-daro?",
            "options" to listOf("Roman civilisation", "Indus Valley Civilization", "Maya civilisation", "Mesopotamian-only civilisation"),
            "correctAnswer" to "Indus Valley Civilization",
            "explanation" to "Harappa and Mohenjo-daro were major urban centres of the Indus Valley Civilization.",
            "isActive" to true,
            "order" to 94
        ),
        mapOf(
            "id" to 125,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani scientist is popularly associated with the country’s nuclear programme?",
            "options" to listOf("Abdus Salam", "Abdul Qadeer Khan", "Dr. Samar Mubarakmand", "Ishfaq Ahmad"),
            "correctAnswer" to "Abdul Qadeer Khan",
            "explanation" to "Abdul Qadeer Khan is widely associated with Pakistan’s uranium-enrichment programme.",
            "isActive" to true,
            "order" to 95
        ),
        mapOf(
            "id" to 126,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "In which year did Pakistan conduct its nuclear tests at Chagai?",
            "options" to listOf("1974", "1988", "1998", "2001"),
            "correctAnswer" to "1998",
            "explanation" to "Pakistan conducted nuclear tests in the Chagai Hills on 28 May 1998.",
            "isActive" to true,
            "order" to 96
        ),
        mapOf(
            "id" to 127,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is observed in Pakistan on 6 September?",
            "options" to listOf("Pakistan Day", "Defence Day", "Kashmir Solidarity Day", "Labour Day"),
            "correctAnswer" to "Defence Day",
            "explanation" to "6 September is observed as Defence Day in Pakistan.",
            "isActive" to true,
            "order" to 97
        ),
        mapOf(
            "id" to 128,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is observed in Pakistan on 23 March?",
            "options" to listOf("Independence Day", "Pakistan Day", "Defence Day", "Iqbal Day"),
            "correctAnswer" to "Pakistan Day",
            "explanation" to "23 March commemorates the Lahore Resolution and the adoption of the 1956 Constitution.",
            "isActive" to true,
            "order" to 98
        ),
        mapOf(
            "id" to 129,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "On which date is Pakistan’s Independence Day celebrated?",
            "options" to listOf("23 March", "14 August", "6 September", "25 December"),
            "correctAnswer" to "14 August",
            "explanation" to "Pakistan celebrates Independence Day on 14 August.",
            "isActive" to true,
            "order" to 99
        ),
        mapOf(
            "id" to 130,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "When is Quaid-e-Azam’s birthday observed?",
            "options" to listOf("9 November", "25 December", "14 August", "11 September"),
            "correctAnswer" to "25 December",
            "explanation" to "Muhammad Ali Jinnah was born on 25 December 1876.",
            "isActive" to true,
            "order" to 100
        ),
        mapOf(
            "id" to 131,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "When is Allama Iqbal’s birthday observed in Pakistan?",
            "options" to listOf("9 November", "21 April", "25 December", "23 March"),
            "correctAnswer" to "9 November",
            "explanation" to "Allama Muhammad Iqbal was born on 9 November 1877.",
            "isActive" to true,
            "order" to 101
        ),
        mapOf(
            "id" to 132,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which is the national monument in Islamabad shaped like a blooming flower?",
            "options" to listOf("Pakistan Monument", "Minar-e-Pakistan", "Bab-e-Khyber", "Chaukhandi Tombs"),
            "correctAnswer" to "Pakistan Monument",
            "explanation" to "The Pakistan Monument in Islamabad symbolises national unity.",
            "isActive" to true,
            "order" to 102
        ),
        mapOf(
            "id" to 133,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani province has its provincial capital at Quetta?",
            "options" to listOf("Punjab", "Sindh", "Balochistan", "Khyber Pakhtunkhwa"),
            "correctAnswer" to "Balochistan",
            "explanation" to "Quetta is the provincial capital of Balochistan.",
            "isActive" to true,
            "order" to 103
        ),
        mapOf(
            "id" to 134,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the provincial capital of Sindh?",
            "options" to listOf("Hyderabad", "Sukkur", "Karachi", "Larkana"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi is the capital of Sindh province.",
            "isActive" to true,
            "order" to 104
        ),
        mapOf(
            "id" to 135,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the provincial capital of Punjab?",
            "options" to listOf("Multan", "Rawalpindi", "Lahore", "Faisalabad"),
            "correctAnswer" to "Lahore",
            "explanation" to "Lahore is the capital of Punjab province.",
            "isActive" to true,
            "order" to 105
        ),
        mapOf(
            "id" to 136,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is the provincial capital of Khyber Pakhtunkhwa?",
            "options" to listOf("Mardan", "Peshawar", "Abbottabad", "Swat"),
            "correctAnswer" to "Peshawar",
            "explanation" to "Peshawar is the capital of Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 106
        ),
        mapOf(
            "id" to 137,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani city is known for its salt mine at Khewra nearby?",
            "options" to listOf("Jhelum", "Karachi", "Turbat", "Chitral"),
            "correctAnswer" to "Jhelum",
            "explanation" to "The Khewra Salt Mine is in the Jhelum District region of Punjab.",
            "isActive" to true,
            "order" to 107
        ),
        mapOf(
            "id" to 138,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which is a major seaport of Pakistan besides Karachi Port?",
            "options" to listOf("Port Qasim", "Torkham", "Wagah", "Sost"),
            "correctAnswer" to "Port Qasim",
            "explanation" to "Port Qasim is a major seaport near Karachi.",
            "isActive" to true,
            "order" to 108
        ),
        mapOf(
            "id" to 139,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which border crossing is a major road link between Pakistan and India near Lahore?",
            "options" to listOf("Khunjerab", "Wagah", "Torkham", "Chaman"),
            "correctAnswer" to "Wagah",
            "explanation" to "The Wagah border crossing is near Lahore on the Pakistan–India border.",
            "isActive" to true,
            "order" to 109
        ),
        mapOf(
            "id" to 140,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which Pakistani city is famous for the annual Shandur Polo Festival region nearby?",
            "options" to listOf("Gilgit", "Hyderabad", "Sahiwal", "Bahawalpur"),
            "correctAnswer" to "Gilgit",
            "explanation" to "Shandur Pass lies between Gilgit-Baltistan and Chitral, and the festival is associated with the region.",
            "isActive" to true,
            "order" to 110
        ),
        mapOf(
            "id" to 141,
            "categoryId" to "pakistan_studies",
            "question" to "Which political party led the Pakistan Movement in the final years before independence?",
            "options" to listOf("Khudai Khidmatgar", "All-India Muslim League", "Unionist Party", "Indian National Congress"),
            "correctAnswer" to "All-India Muslim League",
            "explanation" to "The All-India Muslim League led the political movement that resulted in Pakistan.",
            "isActive" to true,
            "order" to 111
        ),
        mapOf(
            "id" to 142,
            "categoryId" to "pakistan_studies",
            "question" to "In which year was the All-India Muslim League founded?",
            "options" to listOf("1885", "1906", "1930", "1916"),
            "correctAnswer" to "1906",
            "explanation" to "The All-India Muslim League was founded in Dhaka in 1906.",
            "isActive" to true,
            "order" to 112
        ),
        mapOf(
            "id" to 143,
            "categoryId" to "pakistan_studies",
            "question" to "Where was the All-India Muslim League founded?",
            "options" to listOf("Delhi", "Dhaka", "Karachi", "Lahore"),
            "correctAnswer" to "Dhaka",
            "explanation" to "The League was founded at a meeting in Dhaka in December 1906.",
            "isActive" to true,
            "order" to 113
        ),
        mapOf(
            "id" to 144,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the Viceroy of India when the 1947 partition plan was announced?",
            "options" to listOf("Lord Irwin", "Lord Wavell", "Lord Curzon", "Lord Mountbatten"),
            "correctAnswer" to "Lord Mountbatten",
            "explanation" to "Lord Mountbatten announced the 3 June 1947 plan.",
            "isActive" to true,
            "order" to 114
        ),
        mapOf(
            "id" to 145,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the first President of Pakistan?",
            "options" to listOf("Ayub Khan", "Iskander Mirza", "Liaquat Ali Khan", "Muhammad Ali Jinnah"),
            "correctAnswer" to "Iskander Mirza",
            "explanation" to "Iskander Mirza became Pakistan’s first president in 1956.",
            "isActive" to true,
            "order" to 115
        ),
        mapOf(
            "id" to 146,
            "categoryId" to "pakistan_studies",
            "question" to "In which year did Pakistan become an Islamic republic under its first constitution?",
            "options" to listOf("1956", "1962", "1973", "1949"),
            "correctAnswer" to "1956",
            "explanation" to "The 1956 Constitution came into force on 23 March and declared Pakistan an Islamic republic.",
            "isActive" to true,
            "order" to 116
        ),
        mapOf(
            "id" to 147,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the chair of the committee that drafted Pakistan’s 1973 Constitution?",
            "options" to listOf("Abdul Hafeez Pirzada", "Zulfikar Ali Bhutto", "Fazal Ilahi Chaudhry", "Khan Abdul Wali Khan"),
            "correctAnswer" to "Abdul Hafeez Pirzada",
            "explanation" to "Abdul Hafeez Pirzada played a leading role in drafting the 1973 Constitution.",
            "isActive" to true,
            "order" to 117
        ),
        mapOf(
            "id" to 148,
            "categoryId" to "pakistan_studies",
            "question" to "Which constitutional amendment renamed the North-West Frontier Province as Khyber Pakhtunkhwa?",
            "options" to listOf("18th Amendment", "25th Amendment", "8th Amendment", "13th Amendment"),
            "correctAnswer" to "18th Amendment",
            "explanation" to "The 18th Amendment, passed in 2010, renamed the province.",
            "isActive" to true,
            "order" to 118
        ),
        mapOf(
            "id" to 149,
            "categoryId" to "pakistan_studies",
            "question" to "In which year was the Objectives Resolution passed?",
            "options" to listOf("1947", "1973", "1949", "1956"),
            "correctAnswer" to "1949",
            "explanation" to "The Constituent Assembly adopted the Objectives Resolution on 12 March 1949.",
            "isActive" to true,
            "order" to 119
        ),
        mapOf(
            "id" to 150,
            "categoryId" to "pakistan_studies",
            "question" to "Who moved the Objectives Resolution in the Constituent Assembly?",
            "options" to listOf("Muhammad Ali Jinnah", "Khawaja Nazimuddin", "Liaquat Ali Khan", "Iskander Mirza"),
            "correctAnswer" to "Liaquat Ali Khan",
            "explanation" to "Prime Minister Liaquat Ali Khan moved the resolution in March 1949.",
            "isActive" to true,
            "order" to 120
        ),
        mapOf(
            "id" to 151,
            "categoryId" to "pakistan_studies",
            "question" to "Which agreement was signed between Pakistan and India in 1972 after the 1971 war?",
            "options" to listOf("Tashkent Agreement", "Simla Agreement", "Delhi Pact", "Lahore Declaration"),
            "correctAnswer" to "Simla Agreement",
            "explanation" to "The Simla Agreement was signed in July 1972.",
            "isActive" to true,
            "order" to 121
        ),
        mapOf(
            "id" to 152,
            "categoryId" to "pakistan_studies",
            "question" to "Who was Pakistan’s first woman Prime Minister?",
            "options" to listOf("Hina Rabbani Khar", "Benazir Bhutto", "Begum Ra’ana Liaquat Ali Khan", "Fatima Jinnah"),
            "correctAnswer" to "Benazir Bhutto",
            "explanation" to "Benazir Bhutto became prime minister in 1988.",
            "isActive" to true,
            "order" to 122
        ),
        mapOf(
            "id" to 153,
            "categoryId" to "pakistan_studies",
            "question" to "In which year did East Pakistan become the independent country of Bangladesh?",
            "options" to listOf("1965", "1973", "1971", "1969"),
            "correctAnswer" to "1971",
            "explanation" to "Bangladesh emerged as an independent state in December 1971.",
            "isActive" to true,
            "order" to 123
        ),
        mapOf(
            "id" to 154,
            "categoryId" to "pakistan_studies",
            "question" to "Which city hosted the 1974 Islamic Summit Conference in Pakistan?",
            "options" to listOf("Lahore", "Peshawar", "Islamabad", "Karachi"),
            "correctAnswer" to "Lahore",
            "explanation" to "The second Islamic Summit Conference was held in Lahore in February 1974.",
            "isActive" to true,
            "order" to 124
        ),
        mapOf(
            "id" to 155,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the first Chief Justice of Pakistan?",
            "options" to listOf("Muhammad Munir", "A. R. Cornelius", "Iftikhar Muhammad Chaudhry", "Sir Abdul Rashid"),
            "correctAnswer" to "Sir Abdul Rashid",
            "explanation" to "Sir Abdul Rashid became the first Chief Justice of Pakistan in 1949.",
            "isActive" to true,
            "order" to 125
        ),
        mapOf(
            "id" to 156,
            "categoryId" to "pakistan_studies",
            "question" to "Which body is Pakistan’s federal legislature together with the President?",
            "options" to listOf("Council of Common Interests", "Election Commission", "Majlis-e-Shoora (Parliament)", "Supreme Court"),
            "correctAnswer" to "Majlis-e-Shoora (Parliament)",
            "explanation" to "The Constitution describes Parliament as the Majlis-e-Shoora, consisting of the President and two houses.",
            "isActive" to true,
            "order" to 126
        ),
        mapOf(
            "id" to 157,
            "categoryId" to "pakistan_studies",
            "question" to "Which house of Parliament represents the federating units equally?",
            "options" to listOf("National Assembly", "Senate", "Federal Cabinet", "Council of Islamic Ideology"),
            "correctAnswer" to "Senate",
            "explanation" to "The Senate provides equal representation to the federating units.",
            "isActive" to true,
            "order" to 127
        ),
        mapOf(
            "id" to 158,
            "categoryId" to "pakistan_studies",
            "question" to "Which constitutional amendment merged the former Federally Administered Tribal Areas with Khyber Pakhtunkhwa?",
            "options" to listOf("8th Amendment", "18th Amendment", "21st Amendment", "25th Amendment"),
            "correctAnswer" to "25th Amendment",
            "explanation" to "The 25th Amendment was adopted in 2018 and merged FATA with KP.",
            "isActive" to true,
            "order" to 128
        ),
        mapOf(
            "id" to 159,
            "categoryId" to "pakistan_studies",
            "question" to "What is the official name of Pakistan’s 1973 basic law?",
            "options" to listOf("Federal Charter 1973", "Constitution of the Islamic Republic of Pakistan", "Islamabad Constitution Act", "Pakistan Governance Act 1973"),
            "correctAnswer" to "Constitution of the Islamic Republic of Pakistan",
            "explanation" to "The Constitution of the Islamic Republic of Pakistan was adopted in 1973.",
            "isActive" to true,
            "order" to 129
        ),
        mapOf(
            "id" to 160,
            "categoryId" to "pakistan_studies",
            "question" to "Which city was Pakistan’s first capital after independence?",
            "options" to listOf("Lahore", "Rawalpindi", "Islamabad", "Karachi"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi served as Pakistan’s first capital.",
            "isActive" to true,
            "order" to 130
        ),
        mapOf(
            "id" to 161,
            "categoryId" to "pakistan_studies",
            "question" to "Which city served as Pakistan’s interim capital before Islamabad was developed?",
            "options" to listOf("Quetta", "Peshawar", "Rawalpindi", "Multan"),
            "correctAnswer" to "Rawalpindi",
            "explanation" to "Rawalpindi served as the interim capital while Islamabad was being developed.",
            "isActive" to true,
            "order" to 131
        ),
        mapOf(
            "id" to 162,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the first Commander-in-Chief of the Pakistan Army?",
            "options" to listOf("General Douglas Gracey", "General Musa Khan", "General Frank Messervy", "General Ayub Khan"),
            "correctAnswer" to "General Frank Messervy",
            "explanation" to "Frank Messervy was the first Commander-in-Chief after independence.",
            "isActive" to true,
            "order" to 132
        ),
        mapOf(
            "id" to 163,
            "categoryId" to "pakistan_studies",
            "question" to "Which movement demanded restoration of democracy in Pakistan in the late 1980s?",
            "options" to listOf("Pakistan Movement", "Movement for the Restoration of Democracy", "Khilafat Movement", "Swadeshi Movement"),
            "correctAnswer" to "Movement for the Restoration of Democracy",
            "explanation" to "The MRD was an opposition alliance formed in 1981 and active during the 1980s.",
            "isActive" to true,
            "order" to 133
        ),
        mapOf(
            "id" to 164,
            "categoryId" to "pakistan_studies",
            "question" to "Which year did Pakistan join the United Nations?",
            "options" to listOf("1947", "1945", "1956", "1950"),
            "correctAnswer" to "1947",
            "explanation" to "Pakistan became a UN member on 30 September 1947.",
            "isActive" to true,
            "order" to 134
        ),
        mapOf(
            "id" to 165,
            "categoryId" to "pakistan_studies",
            "question" to "Which international organisation did Pakistan help found in 1969 as a Muslim-majority countries forum?",
            "options" to listOf("SAARC", "European Union", "ASEAN", "Organisation of Islamic Cooperation"),
            "correctAnswer" to "Organisation of Islamic Cooperation",
            "explanation" to "The organisation was established in 1969 and was originally called the Organisation of the Islamic Conference.",
            "isActive" to true,
            "order" to 135
        ),
        mapOf(
            "id" to 166,
            "categoryId" to "pakistan_studies",
            "question" to "Which city hosted the first SAARC summit in 1985?",
            "options" to listOf("Islamabad", "Colombo", "Dhaka", "Kathmandu"),
            "correctAnswer" to "Dhaka",
            "explanation" to "The first SAARC summit was held in Dhaka in December 1985.",
            "isActive" to true,
            "order" to 136
        ),
        mapOf(
            "id" to 167,
            "categoryId" to "pakistan_studies",
            "question" to "Who was the first Pakistani to serve as President of the UN General Assembly?",
            "options" to listOf("Abdus Salam", "Agha Shahi", "Liaquat Ali Khan", "Muhammad Zafarullah Khan"),
            "correctAnswer" to "Muhammad Zafarullah Khan",
            "explanation" to "Zafarullah Khan presided over the 17th session of the UN General Assembly in 1962.",
            "isActive" to true,
            "order" to 137
        ),
        mapOf(
            "id" to 168,
            "categoryId" to "pakistan_studies",
            "question" to "Which Pakistani leader presented the idea of a separate Muslim state in his 1930 Allahabad Address?",
            "options" to listOf("Allama Muhammad Iqbal", "Chaudhry Rehmat Ali", "Liaquat Ali Khan", "Sir Syed Ahmad Khan"),
            "correctAnswer" to "Allama Muhammad Iqbal",
            "explanation" to "Iqbal’s 1930 address proposed the consolidation of Muslim-majority regions in north-western India.",
            "isActive" to true,
            "order" to 138
        ),
        mapOf(
            "id" to 169,
            "categoryId" to "pakistan_studies",
            "question" to "Which day commemorates the Lahore Resolution in Pakistan?",
            "options" to listOf("Kashmir Solidarity Day", "Pakistan Day", "Defence Day", "Independence Day"),
            "correctAnswer" to "Pakistan Day",
            "explanation" to "Pakistan Day is observed on 23 March.",
            "isActive" to true,
            "order" to 139
        ),
        mapOf(
            "id" to 170,
            "categoryId" to "pakistan_geography",
            "question" to "Which peak in the Karakoram range is Pakistan’s highest?",
            "options" to listOf("Rakaposhi", "K2", "Tirich Mir", "Nanga Parbat"),
            "correctAnswer" to "K2",
            "explanation" to "K2, in the Karakoram range, is Pakistan’s highest mountain.",
            "isActive" to true,
            "order" to 140
        ),
        mapOf(
            "id" to 171,
            "categoryId" to "pakistan_geography",
            "question" to "Which mountain range contains K2?",
            "options" to listOf("Himalayas", "Karakoram", "Hindu Kush", "Salt Range"),
            "correctAnswer" to "Karakoram",
            "explanation" to "K2 is part of the Karakoram range.",
            "isActive" to true,
            "order" to 141
        ),
        mapOf(
            "id" to 172,
            "categoryId" to "pakistan_geography",
            "question" to "Which is Pakistan’s longest river?",
            "options" to listOf("Indus River", "Sutlej River", "Ravi River", "Jhelum River"),
            "correctAnswer" to "Indus River",
            "explanation" to "The Indus is the principal and longest river flowing through Pakistan.",
            "isActive" to true,
            "order" to 142
        ),
        mapOf(
            "id" to 173,
            "categoryId" to "pakistan_geography",
            "question" to "Pakistan’s southern coastline opens onto which sea?",
            "options" to listOf("Arabian Sea", "Caspian Sea", "Mediterranean Sea", "Red Sea"),
            "correctAnswer" to "Arabian Sea",
            "explanation" to "Pakistan’s southern coastline borders the Arabian Sea.",
            "isActive" to true,
            "order" to 143
        ),
        mapOf(
            "id" to 174,
            "categoryId" to "pakistan_geography",
            "question" to "By land area, which Pakistani province is largest?",
            "options" to listOf("Sindh", "Balochistan", "Punjab", "Khyber Pakhtunkhwa"),
            "correctAnswer" to "Balochistan",
            "explanation" to "Balochistan is Pakistan’s largest province by area.",
            "isActive" to true,
            "order" to 144
        ),
        mapOf(
            "id" to 175,
            "categoryId" to "pakistan_geography",
            "question" to "Which province is the most populous in Pakistan?",
            "options" to listOf("Punjab", "Khyber Pakhtunkhwa", "Sindh", "Balochistan"),
            "correctAnswer" to "Punjab",
            "explanation" to "Punjab is Pakistan’s most populous province.",
            "isActive" to true,
            "order" to 145
        ),
        mapOf(
            "id" to 176,
            "categoryId" to "pakistan_geography",
            "question" to "Which desert is located mainly in southeastern Pakistan?",
            "options" to listOf("Thar Desert", "Katpana Desert", "Cholistan Desert", "Kharan Desert"),
            "correctAnswer" to "Thar Desert",
            "explanation" to "The Thar Desert extends across southeastern Pakistan, especially Sindh, and into India.",
            "isActive" to true,
            "order" to 146
        ),
        mapOf(
            "id" to 177,
            "categoryId" to "pakistan_geography",
            "question" to "Which desert is also known as the Rohi Desert in southern Punjab?",
            "options" to listOf("Cholistan Desert", "Thar Desert", "Thal Desert", "Kharan Desert"),
            "correctAnswer" to "Cholistan Desert",
            "explanation" to "Cholistan, also called Rohi, is in southern Punjab.",
            "isActive" to true,
            "order" to 147
        ),
        mapOf(
            "id" to 178,
            "categoryId" to "pakistan_geography",
            "question" to "Which lake in Sindh is one of Pakistan’s largest freshwater lakes?",
            "options" to listOf("Saif-ul-Malook", "Attabad Lake", "Hanna Lake", "Manchar Lake"),
            "correctAnswer" to "Manchar Lake",
            "explanation" to "Manchar Lake is a large freshwater lake in Sindh.",
            "isActive" to true,
            "order" to 148
        ),
        mapOf(
            "id" to 179,
            "categoryId" to "pakistan_geography",
            "question" to "Which lake was formed after a landslide blocked the Hunza River in 2010?",
            "options" to listOf("Manchar Lake", "Haleji Lake", "Keenjhar Lake", "Attabad Lake"),
            "correctAnswer" to "Attabad Lake",
            "explanation" to "The 2010 landslide created Attabad Lake in Hunza, Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 149
        ),
        mapOf(
            "id" to 180,
            "categoryId" to "pakistan_geography",
            "question" to "Which major dam on the Indus River is located near Topi in Khyber Pakhtunkhwa?",
            "options" to listOf("Tarbela Dam", "Hub Dam", "Warsak Dam", "Mangla Dam"),
            "correctAnswer" to "Tarbela Dam",
            "explanation" to "Tarbela Dam is built on the Indus River in Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 150
        ),
        mapOf(
            "id" to 181,
            "categoryId" to "pakistan_geography",
            "question" to "Which major dam is built on the Jhelum River near Mirpur?",
            "options" to listOf("Tarbela Dam", "Hub Dam", "Diamer-Bhasha Dam", "Mangla Dam"),
            "correctAnswer" to "Mangla Dam",
            "explanation" to "Mangla Dam is on the Jhelum River near Mirpur in Azad Jammu and Kashmir.",
            "isActive" to true,
            "order" to 151
        ),
        mapOf(
            "id" to 182,
            "categoryId" to "pakistan_geography",
            "question" to "Which pass connects Pakistan with China via the Karakoram Highway?",
            "options" to listOf("Khyber Pass", "Bolan Pass", "Khunjerab Pass", "Lowari Pass"),
            "correctAnswer" to "Khunjerab Pass",
            "explanation" to "Khunjerab Pass is the high mountain border crossing between Pakistan and China.",
            "isActive" to true,
            "order" to 152
        ),
        mapOf(
            "id" to 183,
            "categoryId" to "pakistan_geography",
            "question" to "Which historic pass links the Peshawar valley with Afghanistan?",
            "options" to listOf("Shandur Pass", "Khunjerab Pass", "Khyber Pass", "Babusar Pass"),
            "correctAnswer" to "Khyber Pass",
            "explanation" to "The Khyber Pass has long been a major route between the Peshawar region and Afghanistan.",
            "isActive" to true,
            "order" to 153
        ),
        mapOf(
            "id" to 184,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the capital of Gilgit-Baltistan?",
            "options" to listOf("Hunza", "Skardu", "Gilgit", "Chilas"),
            "correctAnswer" to "Gilgit",
            "explanation" to "Gilgit is the administrative capital of Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 154
        ),
        mapOf(
            "id" to 185,
            "categoryId" to "pakistan_geography",
            "question" to "Which river flows through the city of Hyderabad in Sindh region nearby?",
            "options" to listOf("Ravi River", "Chenab River", "Indus River", "Kabul River"),
            "correctAnswer" to "Indus River",
            "explanation" to "Hyderabad is situated near the Indus River in Sindh.",
            "isActive" to true,
            "order" to 155
        ),
        mapOf(
            "id" to 186,
            "categoryId" to "pakistan_geography",
            "question" to "Which Pakistani city is known as the “City of Gardens”?",
            "options" to listOf("Lahore", "Sukkur", "Quetta", "Karachi"),
            "correctAnswer" to "Lahore",
            "explanation" to "Lahore is popularly known as the City of Gardens.",
            "isActive" to true,
            "order" to 156
        ),
        mapOf(
            "id" to 187,
            "categoryId" to "pakistan_geography",
            "question" to "Which city is known as Pakistan’s “City of Lights”?",
            "options" to listOf("Lahore", "Islamabad", "Faisalabad", "Karachi"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi is commonly nicknamed the City of Lights.",
            "isActive" to true,
            "order" to 157
        ),
        mapOf(
            "id" to 188,
            "categoryId" to "pakistan_geography",
            "question" to "Which coastal city is the site of Pakistan’s deep-sea port project?",
            "options" to listOf("Sukkur", "Sialkot", "Abbottabad", "Gwadar"),
            "correctAnswer" to "Gwadar",
            "explanation" to "Gwadar is a port city on the Balochistan coast.",
            "isActive" to true,
            "order" to 158
        ),
        mapOf(
            "id" to 189,
            "categoryId" to "pakistan_geography",
            "question" to "Which national park in Gilgit-Baltistan is famous for snow leopards and high mountains?",
            "options" to listOf("Khunjerab National Park", "Margalla Hills National Park", "Hingol National Park", "Lal Suhanra National Park"),
            "correctAnswer" to "Khunjerab National Park",
            "explanation" to "Khunjerab National Park protects high-altitude habitats in Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 159
        ),
        mapOf(
            "id" to 190,
            "categoryId" to "pakistan_geography",
            "question" to "Which national park in Balochistan contains the Princess of Hope rock formation?",
            "options" to listOf("Hingol National Park", "Khunjerab National Park", "Chitral Gol National Park", "Ayubia National Park"),
            "correctAnswer" to "Hingol National Park",
            "explanation" to "The Princess of Hope formation is located in Hingol National Park.",
            "isActive" to true,
            "order" to 160
        ),
        mapOf(
            "id" to 191,
            "categoryId" to "pakistan_geography",
            "question" to "Which plateau in western Pakistan is associated with Quetta and surrounding highlands?",
            "options" to listOf("Balochistan Plateau", "Potohar Plateau", "Tibetan Plateau", "Deccan Plateau"),
            "correctAnswer" to "Balochistan Plateau",
            "explanation" to "Quetta lies in the highlands of the Balochistan Plateau.",
            "isActive" to true,
            "order" to 161
        ),
        mapOf(
            "id" to 192,
            "categoryId" to "pakistan_geography",
            "question" to "Which plateau is located in northern Punjab around Rawalpindi and Jhelum?",
            "options" to listOf("Potohar Plateau", "Deosai Plateau", "Kathiawar Plateau", "Balochistan Plateau"),
            "correctAnswer" to "Potohar Plateau",
            "explanation" to "The Potohar Plateau covers parts of northern Punjab.",
            "isActive" to true,
            "order" to 162
        ),
        mapOf(
            "id" to 193,
            "categoryId" to "pakistan_geography",
            "question" to "Which river joins the Indus near Mithankot?",
            "options" to listOf("Kabul River", "Panjnad River", "Swat River", "Ravi River"),
            "correctAnswer" to "Panjnad River",
            "explanation" to "The Panjnad is formed by the confluence of Punjab’s major rivers and joins the Indus near Mithankot.",
            "isActive" to true,
            "order" to 163
        ),
        mapOf(
            "id" to 194,
            "categoryId" to "pakistan_geography",
            "question" to "Which river flows through Peshawar valley and joins the Indus near Attock?",
            "options" to listOf("Kabul River", "Sutlej River", "Ravi River", "Hingol River"),
            "correctAnswer" to "Kabul River",
            "explanation" to "The Kabul River joins the Indus near Attock.",
            "isActive" to true,
            "order" to 164
        ),
        mapOf(
            "id" to 195,
            "categoryId" to "pakistan_geography",
            "question" to "Which is the largest city of Pakistan by population?",
            "options" to listOf("Karachi", "Faisalabad", "Peshawar", "Lahore"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi is Pakistan’s largest city by population.",
            "isActive" to true,
            "order" to 165
        ),
        mapOf(
            "id" to 196,
            "categoryId" to "pakistan_geography",
            "question" to "Which mountain peak in Pakistan is the world’s ninth-highest mountain?",
            "options" to listOf("Gasherbrum II", "Rakaposhi", "Broad Peak", "Nanga Parbat"),
            "correctAnswer" to "Nanga Parbat",
            "explanation" to "Nanga Parbat is the ninth-highest mountain in the world.",
            "isActive" to true,
            "order" to 166
        ),
        mapOf(
            "id" to 197,
            "categoryId" to "pakistan_geography",
            "question" to "Which high-altitude plain in Gilgit-Baltistan is famous for Deosai National Park?",
            "options" to listOf("Thal Desert", "Potohar Plateau", "Deosai Plains", "Cholistan"),
            "correctAnswer" to "Deosai Plains",
            "explanation" to "Deosai is a high-altitude plateau and national park in Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 167
        ),
        mapOf(
            "id" to 198,
            "categoryId" to "pakistan_geography",
            "question" to "Which city is the provincial capital of Balochistan?",
            "options" to listOf("Turbat", "Khuzdar", "Quetta", "Gwadar"),
            "correctAnswer" to "Quetta",
            "explanation" to "Quetta is the capital of Balochistan province.",
            "isActive" to true,
            "order" to 168
        ),
        mapOf(
            "id" to 199,
            "categoryId" to "islamiat",
            "question" to "How many pillars of Islam are commonly taught in Sunni Islam?",
            "options" to listOf("Six", "Four", "Five", "Three"),
            "correctAnswer" to "Five",
            "explanation" to "The five pillars are the shahada, prayer, zakat, fasting in Ramadan, and Hajj for those able.",
            "isActive" to true,
            "order" to 169
        ),
        mapOf(
            "id" to 200,
            "categoryId" to "islamiat",
            "question" to "How many obligatory daily prayers are observed in Islam?",
            "options" to listOf("Seven", "Three", "Four", "Five"),
            "correctAnswer" to "Five",
            "explanation" to "Muslims perform five obligatory daily prayers.",
            "isActive" to true,
            "order" to 170
        ),
        mapOf(
            "id" to 201,
            "categoryId" to "islamiat",
            "question" to "Which month is observed as the month of fasting by Muslims?",
            "options" to listOf("Ramadan", "Shawwal", "Rajab", "Muharram"),
            "correctAnswer" to "Ramadan",
            "explanation" to "Fasting from dawn to sunset is observed during Ramadan.",
            "isActive" to true,
            "order" to 171
        ),
        mapOf(
            "id" to 202,
            "categoryId" to "islamiat",
            "question" to "What is the name of the obligatory charity in Islam?",
            "options" to listOf("Fidyah", "Zakat", "Waqf", "Sadaqah only"),
            "correctAnswer" to "Zakat",
            "explanation" to "Zakat is a prescribed form of charitable giving for eligible Muslims.",
            "isActive" to true,
            "order" to 172
        ),
        mapOf(
            "id" to 203,
            "categoryId" to "islamiat",
            "question" to "What is the pilgrimage to Makkah called?",
            "options" to listOf("Hajj", "Ziyarah", "Hijrah", "Umrah"),
            "correctAnswer" to "Hajj",
            "explanation" to "Hajj is the annual pilgrimage to Makkah required once for Muslims who are able.",
            "isActive" to true,
            "order" to 173
        ),
        mapOf(
            "id" to 204,
            "categoryId" to "islamiat",
            "question" to "Which is the holy book of Islam?",
            "options" to listOf("Bible", "The Quran", "Torah", "Psalms"),
            "correctAnswer" to "The Quran",
            "explanation" to "Muslims regard the Quran as the revelation to Prophet Muhammad.",
            "isActive" to true,
            "order" to 174
        ),
        mapOf(
            "id" to 205,
            "categoryId" to "islamiat",
            "question" to "In which city is the Kaaba located?",
            "options" to listOf("Madinah", "Taif", "Makkah", "Jerusalem"),
            "correctAnswer" to "Makkah",
            "explanation" to "The Kaaba is located inside Masjid al-Haram in Makkah.",
            "isActive" to true,
            "order" to 175
        ),
        mapOf(
            "id" to 206,
            "categoryId" to "islamiat",
            "question" to "Which city did Prophet Muhammad migrate to from Makkah?",
            "options" to listOf("Kufa", "Madinah", "Taif", "Jerusalem"),
            "correctAnswer" to "Madinah",
            "explanation" to "The Hijrah was the migration from Makkah to Madinah in 622 CE.",
            "isActive" to true,
            "order" to 176
        ),
        mapOf(
            "id" to 207,
            "categoryId" to "islamiat",
            "question" to "What is the direction Muslims face during prayer called?",
            "options" to listOf("Qiblah", "Minbar", "Maqam", "Mihrab"),
            "correctAnswer" to "Qiblah",
            "explanation" to "Qiblah is the direction toward the Kaaba in Makkah.",
            "isActive" to true,
            "order" to 177
        ),
        mapOf(
            "id" to 208,
            "categoryId" to "islamiat",
            "question" to "Which angel is traditionally associated with bringing revelation to prophets?",
            "options" to listOf("Mikail", "Malik", "Israfil", "Jibril (Gabriel)"),
            "correctAnswer" to "Jibril (Gabriel)",
            "explanation" to "Jibril is identified in Islamic tradition as the angel who conveyed revelation.",
            "isActive" to true,
            "order" to 178
        ),
        mapOf(
            "id" to 209,
            "categoryId" to "islamiat",
            "question" to "Which Islamic calendar month follows Ramadan?",
            "options" to listOf("Safar", "Rajab", "Dhul-Qadah", "Shawwal"),
            "correctAnswer" to "Shawwal",
            "explanation" to "Shawwal follows Ramadan and begins with Eid al-Fitr.",
            "isActive" to true,
            "order" to 179
        ),
        mapOf(
            "id" to 210,
            "categoryId" to "islamiat",
            "question" to "Which Eid marks the end of Ramadan?",
            "options" to listOf("Mawlid", "Ashura", "Eid al-Fitr", "Eid al-Adha"),
            "correctAnswer" to "Eid al-Fitr",
            "explanation" to "Eid al-Fitr is celebrated at the end of Ramadan.",
            "isActive" to true,
            "order" to 180
        ),
        mapOf(
            "id" to 211,
            "categoryId" to "islamiat",
            "question" to "Which Eid is associated with the Hajj season and sacrifice?",
            "options" to listOf("Eid al-Fitr", "Ashura", "Eid al-Adha", "Shab-e-Barat"),
            "correctAnswer" to "Eid al-Adha",
            "explanation" to "Eid al-Adha occurs during the Hajj period in Dhul-Hijjah.",
            "isActive" to true,
            "order" to 181
        ),
        mapOf(
            "id" to 212,
            "categoryId" to "islamiat",
            "question" to "What is the Islamic announcement of prayer times called?",
            "options" to listOf("Adhan", "Iqamah", "Tasbih", "Khutbah"),
            "correctAnswer" to "Adhan",
            "explanation" to "The adhan announces the time for prayer.",
            "isActive" to true,
            "order" to 182
        ),
        mapOf(
            "id" to 213,
            "categoryId" to "islamiat",
            "question" to "What is the sermon delivered during Friday congregational prayer called?",
            "options" to listOf("Adhan", "Tilawah", "Khutbah", "Iqamah"),
            "correctAnswer" to "Khutbah",
            "explanation" to "The khutbah is the sermon associated with Friday prayer.",
            "isActive" to true,
            "order" to 183
        ),
        mapOf(
            "id" to 214,
            "categoryId" to "islamiat",
            "question" to "What is the name of the short chapter that opens the Quran?",
            "options" to listOf("Al-Ikhlas", "Al-Baqarah", "An-Nas", "Al-Fatihah"),
            "correctAnswer" to "Al-Fatihah",
            "explanation" to "Surah Al-Fatihah is the opening chapter of the Quran.",
            "isActive" to true,
            "order" to 184
        ),
        mapOf(
            "id" to 215,
            "categoryId" to "islamiat",
            "question" to "Which is the longest chapter of the Quran?",
            "options" to listOf("An-Nisa", "Al-Baqarah", "Al-Imran", "Yasin"),
            "correctAnswer" to "Al-Baqarah",
            "explanation" to "Surah Al-Baqarah is the Quran’s longest chapter.",
            "isActive" to true,
            "order" to 185
        ),
        mapOf(
            "id" to 216,
            "categoryId" to "islamiat",
            "question" to "Which surah is commonly identified as the Quran’s shortest chapter by length?",
            "options" to listOf("Al-Asr", "Al-Kawthar", "Al-Ikhlas", "Al-Falaq"),
            "correctAnswer" to "Al-Kawthar",
            "explanation" to "Surah Al-Kawthar has three verses and is commonly identified as the shortest chapter.",
            "isActive" to true,
            "order" to 186
        ),
        mapOf(
            "id" to 217,
            "categoryId" to "islamiat",
            "question" to "What does “Hijrah” refer to in Islamic history?",
            "options" to listOf("The migration from Makkah to Madinah", "The first revelation", "The conquest of Makkah", "The Farewell Pilgrimage"),
            "correctAnswer" to "The migration from Makkah to Madinah",
            "explanation" to "The Hijrah of Prophet Muhammad and early Muslims took place in 622 CE.",
            "isActive" to true,
            "order" to 187
        ),
        mapOf(
            "id" to 218,
            "categoryId" to "islamiat",
            "question" to "Which mosque in Madinah is closely associated with Prophet Muhammad?",
            "options" to listOf("Masjid al-Aqsa", "Masjid al-Haram", "Masjid Quba only", "Al-Masjid an-Nabawi"),
            "correctAnswer" to "Al-Masjid an-Nabawi",
            "explanation" to "The Prophet’s Mosque is in Madinah.",
            "isActive" to true,
            "order" to 188
        ),
        mapOf(
            "id" to 219,
            "categoryId" to "islamiat",
            "question" to "Which mosque in Jerusalem is one of Islam’s major holy sites?",
            "options" to listOf("Badshahi Mosque", "Faisal Mosque", "Al-Aqsa Mosque", "Masjid Quba"),
            "correctAnswer" to "Al-Aqsa Mosque",
            "explanation" to "Al-Aqsa Mosque is located in Jerusalem.",
            "isActive" to true,
            "order" to 189
        ),
        mapOf(
            "id" to 220,
            "categoryId" to "islamiat",
            "question" to "Which Islamic term refers to the community-wide obligatory Friday prayer?",
            "options" to listOf("Jumu’ah", "Witr", "Tahajjud", "Duha"),
            "correctAnswer" to "Jumu’ah",
            "explanation" to "Jumu’ah is the congregational Friday prayer.",
            "isActive" to true,
            "order" to 190
        ),
        mapOf(
            "id" to 221,
            "categoryId" to "islamiat",
            "question" to "What is the pre-dawn meal before fasting called?",
            "options" to listOf("Iftar", "Aqiqah", "Suhoor", "Walima"),
            "correctAnswer" to "Suhoor",
            "explanation" to "Suhoor is eaten before dawn during fasting days.",
            "isActive" to true,
            "order" to 191
        ),
        mapOf(
            "id" to 222,
            "categoryId" to "islamiat",
            "question" to "What is the meal to break the fast at sunset called?",
            "options" to listOf("Iftar", "Niyyah", "Sadaqah", "Suhoor"),
            "correctAnswer" to "Iftar",
            "explanation" to "Iftar is the meal with which Muslims break the daily fast.",
            "isActive" to true,
            "order" to 192
        ),
        mapOf(
            "id" to 223,
            "categoryId" to "islamiat",
            "question" to "Which month begins the Islamic lunar year?",
            "options" to listOf("Muharram", "Ramadan", "Safar", "Dhul-Hijjah"),
            "correctAnswer" to "Muharram",
            "explanation" to "Muharram is the first month of the Islamic calendar.",
            "isActive" to true,
            "order" to 193
        ),
        mapOf(
            "id" to 224,
            "categoryId" to "islamiat",
            "question" to "What is the term for a charitable endowment in Islamic tradition?",
            "options" to listOf("Zakat", "Hajj", "Waqf", "Riba"),
            "correctAnswer" to "Waqf",
            "explanation" to "A waqf is an endowment dedicated to a charitable or religious purpose.",
            "isActive" to true,
            "order" to 194
        ),
        mapOf(
            "id" to 225,
            "categoryId" to "islamiat",
            "question" to "Which term means the practice and teachings attributed to Prophet Muhammad?",
            "options" to listOf("Fiqh only", "Ijma", "Tafsir", "Sunnah"),
            "correctAnswer" to "Sunnah",
            "explanation" to "The Sunnah refers to the Prophet’s teachings, practices, and approvals.",
            "isActive" to true,
            "order" to 195
        ),
        mapOf(
            "id" to 226,
            "categoryId" to "islamiat",
            "question" to "What is the interpretation or exegesis of the Quran called?",
            "options" to listOf("Hadith", "Tafsir", "Aqidah", "Seerah"),
            "correctAnswer" to "Tafsir",
            "explanation" to "Tafsir is the scholarly explanation of Quranic text.",
            "isActive" to true,
            "order" to 196
        ),
        mapOf(
            "id" to 227,
            "categoryId" to "islamiat",
            "question" to "What is the collection of reports about Prophet Muhammad’s words and actions called?",
            "options" to listOf("Tafsir", "Hadith", "Qiyas", "Fiqh"),
            "correctAnswer" to "Hadith",
            "explanation" to "Hadith literature records reports about the Prophet’s sayings and actions.",
            "isActive" to true,
            "order" to 197
        ),
        mapOf(
            "id" to 228,
            "categoryId" to "islamiat",
            "question" to "Which Pakistani constitutional body advises on whether laws conform to Islamic injunctions?",
            "options" to listOf("Council of Islamic Ideology", "Federal Public Service Commission", "National Economic Council", "Election Commission of Pakistan"),
            "correctAnswer" to "Council of Islamic Ideology",
            "explanation" to "The Council of Islamic Ideology advises Pakistan’s Parliament and provincial assemblies on Islamic conformity of laws.",
            "isActive" to true,
            "order" to 198
        ),
        mapOf(
            "id" to 229,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is the national language of Pakistan?",
            "options" to listOf("Pashto", "Punjabi", "Urdu", "Sindhi"),
            "correctAnswer" to "Urdu",
            "explanation" to "Urdu is Pakistan’s national language.",
            "isActive" to true,
            "order" to 199
        ),
        mapOf(
            "id" to 230,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is widely spoken in Punjab?",
            "options" to listOf("Punjabi", "Brahui", "Balochi", "Shina"),
            "correctAnswer" to "Punjabi",
            "explanation" to "Punjabi is widely spoken across Punjab.",
            "isActive" to true,
            "order" to 200
        ),
        mapOf(
            "id" to 231,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is widely spoken in Sindh besides Urdu?",
            "options" to listOf("Pashto", "Sindhi", "Balti", "Kashmiri"),
            "correctAnswer" to "Sindhi",
            "explanation" to "Sindhi is the provincial language of Sindh.",
            "isActive" to true,
            "order" to 201
        ),
        mapOf(
            "id" to 232,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is widely spoken in Khyber Pakhtunkhwa?",
            "options" to listOf("Saraiki", "Balochi", "Sindhi", "Pashto"),
            "correctAnswer" to "Pashto",
            "explanation" to "Pashto is widely spoken in Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 202
        ),
        mapOf(
            "id" to 233,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is associated with much of Balochistan?",
            "options" to listOf("Khowar", "Hindko", "Balochi", "Punjabi"),
            "correctAnswer" to "Balochi",
            "explanation" to "Balochi is one of the major languages of Balochistan.",
            "isActive" to true,
            "order" to 203
        ),
        mapOf(
            "id" to 234,
            "categoryId" to "pakistan_culture",
            "question" to "Which Sufi poet wrote poetry in Punjabi and is associated with the Kafi form?",
            "options" to listOf("Bulleh Shah", "Faiz Ahmad Faiz", "Josh Malihabadi", "Mir Taqi Mir"),
            "correctAnswer" to "Bulleh Shah",
            "explanation" to "Bulleh Shah was a prominent Punjabi Sufi poet.",
            "isActive" to true,
            "order" to 204
        ),
        mapOf(
            "id" to 235,
            "categoryId" to "pakistan_culture",
            "question" to "Which Punjabi Sufi poet is associated with the epic Heer Ranjha?",
            "options" to listOf("Waris Shah", "Bulleh Shah", "Shah Abdul Latif Bhittai", "Mian Muhammad Bakhsh"),
            "correctAnswer" to "Waris Shah",
            "explanation" to "Waris Shah’s version of Heer is a celebrated Punjabi literary work.",
            "isActive" to true,
            "order" to 205
        ),
        mapOf(
            "id" to 236,
            "categoryId" to "pakistan_culture",
            "question" to "Which Sindhi Sufi poet is celebrated for Shah Jo Risalo?",
            "options" to listOf("Shah Abdul Latif Bhittai", "Bulleh Shah", "Khawaja Ghulam Farid", "Sachal Sarmast"),
            "correctAnswer" to "Shah Abdul Latif Bhittai",
            "explanation" to "Shah Jo Risalo is the major poetic collection associated with Shah Abdul Latif Bhittai.",
            "isActive" to true,
            "order" to 206
        ),
        mapOf(
            "id" to 237,
            "categoryId" to "pakistan_culture",
            "question" to "Which Pashto poet is often called the “Father of Pashto Literature”?",
            "options" to listOf("Rahman Baba", "Khushal Khan Khattak", "Hamza Shinwari", "Ajmal Khattak"),
            "correctAnswer" to "Khushal Khan Khattak",
            "explanation" to "Khushal Khan Khattak was a renowned Pashto poet and tribal chief.",
            "isActive" to true,
            "order" to 207
        ),
        mapOf(
            "id" to 238,
            "categoryId" to "pakistan_culture",
            "question" to "Which poet wrote the Urdu poem “Lab Pe Aati Hai Dua”?",
            "options" to listOf("Allama Muhammad Iqbal", "Faiz Ahmad Faiz", "Hafeez Jalandhari", "Mirza Ghalib"),
            "correctAnswer" to "Allama Muhammad Iqbal",
            "explanation" to "The well-known prayer poem was written by Allama Iqbal.",
            "isActive" to true,
            "order" to 208
        ),
        mapOf(
            "id" to 239,
            "categoryId" to "pakistan_culture",
            "question" to "Who wrote the lyrics of Pakistan’s national anthem?",
            "options" to listOf("Ahmed G. Chagla", "Allama Iqbal", "Faiz Ahmad Faiz", "Hafeez Jalandhari"),
            "correctAnswer" to "Hafeez Jalandhari",
            "explanation" to "Hafeez Jalandhari wrote the Urdu lyrics of the national anthem.",
            "isActive" to true,
            "order" to 209
        ),
        mapOf(
            "id" to 240,
            "categoryId" to "pakistan_culture",
            "question" to "Who composed the tune of Pakistan’s national anthem?",
            "options" to listOf("Hafeez Jalandhari", "Nisar Bazmi", "Ahmed G. Chagla", "Sohail Rana"),
            "correctAnswer" to "Ahmed G. Chagla",
            "explanation" to "Ahmed G. Chagla composed the national anthem’s tune.",
            "isActive" to true,
            "order" to 210
        ),
        mapOf(
            "id" to 241,
            "categoryId" to "pakistan_culture",
            "question" to "Which traditional Pakistani garment consists of a long shirt worn with loose trousers?",
            "options" to listOf("Sari only", "Kimono", "Kilt", "Shalwar kameez"),
            "correctAnswer" to "Shalwar kameez",
            "explanation" to "Shalwar kameez is widely worn in Pakistan.",
            "isActive" to true,
            "order" to 211
        ),
        mapOf(
            "id" to 242,
            "categoryId" to "pakistan_culture",
            "question" to "Which craft is Multan especially famous for?",
            "options" to listOf("Blue pottery", "Ajrak printing only", "Pashmina weaving", "Truck manufacturing"),
            "correctAnswer" to "Blue pottery",
            "explanation" to "Multan is well known for blue pottery and glazed tilework.",
            "isActive" to true,
            "order" to 212
        ),
        mapOf(
            "id" to 243,
            "categoryId" to "pakistan_culture",
            "question" to "Which traditional block-printed cloth is strongly associated with Sindh?",
            "options" to listOf("Ajrak", "Kashmiri pheran", "Phulkari", "Pashmina"),
            "correctAnswer" to "Ajrak",
            "explanation" to "Ajrak is a traditional block-printed textile associated with Sindh.",
            "isActive" to true,
            "order" to 213
        ),
        mapOf(
            "id" to 244,
            "categoryId" to "pakistan_culture",
            "question" to "Which embroidered shawl tradition is associated with Balochistan?",
            "options" to listOf("Chikankari", "Ajrak", "Balochi embroidery", "Phulkari"),
            "correctAnswer" to "Balochi embroidery",
            "explanation" to "Balochi embroidery is known for geometric patterns and vivid colors.",
            "isActive" to true,
            "order" to 214
        ),
        mapOf(
            "id" to 245,
            "categoryId" to "pakistan_culture",
            "question" to "Which city is famous for truck art workshops and decorated vehicles?",
            "options" to listOf("Chitral", "Skardu", "Karachi", "Murree"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi has a prominent truck-art industry, alongside other Pakistani cities.",
            "isActive" to true,
            "order" to 215
        ),
        mapOf(
            "id" to 246,
            "categoryId" to "pakistan_culture",
            "question" to "Which Pakistani city is internationally known for sports-goods manufacturing?",
            "options" to listOf("Sialkot", "Gwadar", "Khuzdar", "Mianwali"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot is a major centre for sporting goods manufacturing.",
            "isActive" to true,
            "order" to 216
        ),
        mapOf(
            "id" to 247,
            "categoryId" to "pakistan_culture",
            "question" to "Which city is famous for handmade football production?",
            "options" to listOf("Hyderabad", "Quetta", "Sialkot", "Gilgit"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot is globally known for hand-stitched and machine-made footballs.",
            "isActive" to true,
            "order" to 217
        ),
        mapOf(
            "id" to 248,
            "categoryId" to "pakistan_culture",
            "question" to "Which dish is commonly associated with Karachi’s food culture and made with rice and meat?",
            "options" to listOf("Biryani", "Sarson da saag", "Chapli kebab only", "Sajji only"),
            "correctAnswer" to "Biryani",
            "explanation" to "Biryani is a popular rice dish, especially associated with Karachi’s food scene.",
            "isActive" to true,
            "order" to 218
        ),
        mapOf(
            "id" to 249,
            "categoryId" to "pakistan_culture",
            "question" to "Which Balochi dish is traditionally made with whole lamb or large pieces of meat roasted?",
            "options" to listOf("Sarson da saag", "Haleem", "Sajji", "Nihari"),
            "correctAnswer" to "Sajji",
            "explanation" to "Sajji is a well-known Balochi-style roasted meat dish.",
            "isActive" to true,
            "order" to 219
        ),
        mapOf(
            "id" to 250,
            "categoryId" to "pakistan_culture",
            "question" to "Which dish from Peshawar is commonly made with minced meat and spices?",
            "options" to listOf("Sindhi biryani", "Saag", "Chapli kebab", "Sohan halwa"),
            "correctAnswer" to "Chapli kebab",
            "explanation" to "Chapli kebab is strongly associated with Pashtun cuisine and Peshawar.",
            "isActive" to true,
            "order" to 220
        ),
        mapOf(
            "id" to 251,
            "categoryId" to "pakistan_culture",
            "question" to "Which sweet is especially associated with Multan?",
            "options" to listOf("Sohan halwa", "Gulab jamun only", "Kulfi only", "Jalebi only"),
            "correctAnswer" to "Sohan halwa",
            "explanation" to "Multan is famous for its sohan halwa.",
            "isActive" to true,
            "order" to 221
        ),
        mapOf(
            "id" to 252,
            "categoryId" to "pakistan_culture",
            "question" to "Which festival is celebrated in spring in parts of Punjab with kite-flying traditions?",
            "options" to listOf("Lok Mela", "Basant", "Urs of Lal Shahbaz Qalandar", "Shandur Polo Festival"),
            "correctAnswer" to "Basant",
            "explanation" to "Basant is a spring festival historically associated with kite flying in Punjab, though restrictions may apply.",
            "isActive" to true,
            "order" to 222
        ),
        mapOf(
            "id" to 253,
            "categoryId" to "pakistan_culture",
            "question" to "Which annual polo festival is held at a high-altitude ground between Chitral and Gilgit-Baltistan?",
            "options" to listOf("Lok Mela", "Basant", "Shandur Polo Festival", "Kalash Chilam Joshi"),
            "correctAnswer" to "Shandur Polo Festival",
            "explanation" to "The Shandur Polo Festival takes place at Shandur Pass.",
            "isActive" to true,
            "order" to 223
        ),
        mapOf(
            "id" to 254,
            "categoryId" to "pakistan_culture",
            "question" to "Which festival is associated with the Kalash communities in Chitral and celebrated in spring?",
            "options" to listOf("Mela Chiraghan", "Basant", "Urs of Data Ganj Bakhsh", "Chilam Joshi"),
            "correctAnswer" to "Chilam Joshi",
            "explanation" to "Chilam Joshi is a spring festival of the Kalash people.",
            "isActive" to true,
            "order" to 224
        ),
        mapOf(
            "id" to 255,
            "categoryId" to "pakistan_culture",
            "question" to "Which folk dance is associated with Punjab and performed energetically in groups?",
            "options" to listOf("Khattak dance", "Lewah", "Attan", "Bhangra"),
            "correctAnswer" to "Bhangra",
            "explanation" to "Bhangra is a traditional Punjabi folk dance.",
            "isActive" to true,
            "order" to 225
        ),
        mapOf(
            "id" to 256,
            "categoryId" to "pakistan_culture",
            "question" to "Which traditional dance is associated with Pashtun culture?",
            "options" to listOf("Ho Jamalo", "Bhangra", "Attan", "Jhumar"),
            "correctAnswer" to "Attan",
            "explanation" to "Attan is a traditional Pashtun group dance.",
            "isActive" to true,
            "order" to 226
        ),
        mapOf(
            "id" to 257,
            "categoryId" to "pakistan_culture",
            "question" to "Which Sindhi folk dance is associated with the song “Ho Jamalo”?",
            "options" to listOf("Bhangra", "Ho Jamalo", "Attan", "Khattak"),
            "correctAnswer" to "Ho Jamalo",
            "explanation" to "Ho Jamalo is a well-known Sindhi folk song and dance tradition.",
            "isActive" to true,
            "order" to 227
        ),
        mapOf(
            "id" to 258,
            "categoryId" to "pakistan_culture",
            "question" to "Which region is especially associated with the Kalash people?",
            "options" to listOf("Potohar", "Tharparkar", "Chitral", "Makran"),
            "correctAnswer" to "Chitral",
            "explanation" to "The Kalash communities live in valleys in the Chitral region of Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 228
        ),
        mapOf(
            "id" to 259,
            "categoryId" to "pakistan_culture",
            "question" to "Which Pakistani city is home to the shrine of Lal Shahbaz Qalandar?",
            "options" to listOf("Lahore", "Sehwan Sharif", "Peshawar", "Multan"),
            "correctAnswer" to "Sehwan Sharif",
            "explanation" to "The shrine of Lal Shahbaz Qalandar is in Sehwan Sharif, Sindh.",
            "isActive" to true,
            "order" to 229
        ),
        mapOf(
            "id" to 260,
            "categoryId" to "pakistan_culture",
            "question" to "Which Lahore shrine is associated with the Sufi saint Ali Hujwiri?",
            "options" to listOf("Lal Shahbaz Qalandar", "Abdullah Shah Ghazi", "Data Darbar", "Bari Imam"),
            "correctAnswer" to "Data Darbar",
            "explanation" to "Data Darbar is the shrine of Ali Hujwiri, also known as Data Ganj Bakhsh.",
            "isActive" to true,
            "order" to 230
        ),
        mapOf(
            "id" to 261,
            "categoryId" to "pakistan_culture",
            "question" to "Which Karachi shrine is associated with the Sufi saint Abdullah Shah Ghazi?",
            "options" to listOf("Clifton, Karachi", "Uch Sharif", "Multan", "Sehwan Sharif"),
            "correctAnswer" to "Clifton, Karachi",
            "explanation" to "The shrine of Abdullah Shah Ghazi is located in Clifton, Karachi.",
            "isActive" to true,
            "order" to 231
        ),
        mapOf(
            "id" to 262,
            "categoryId" to "pakistan_culture",
            "question" to "Which historic city in Punjab is known for its Sufi shrines and old walled city?",
            "options" to listOf("Mardan", "Multan", "Turbat", "Gwadar"),
            "correctAnswer" to "Multan",
            "explanation" to "Multan is famous for its historic Sufi shrines and heritage.",
            "isActive" to true,
            "order" to 232
        ),
        mapOf(
            "id" to 263,
            "categoryId" to "pakistan_culture",
            "question" to "Which traditional bowed string instrument is used in Balochi music?",
            "options" to listOf("Suroz", "Bagpipes", "Banjo", "Harpsichord"),
            "correctAnswer" to "Suroz",
            "explanation" to "The suroz is a bowed string instrument associated with Balochi music.",
            "isActive" to true,
            "order" to 233
        ),
        mapOf(
            "id" to 264,
            "categoryId" to "pakistan_culture",
            "question" to "Which string instrument is strongly associated with Pashtun folk music?",
            "options" to listOf("Mandolin only", "Rabab", "Cello", "Sitar only"),
            "correctAnswer" to "Rabab",
            "explanation" to "The rabab is a traditional plucked string instrument used in Pashtun music.",
            "isActive" to true,
            "order" to 234
        ),
        mapOf(
            "id" to 265,
            "categoryId" to "pakistan_culture",
            "question" to "Which traditional string instrument is associated with Sindhi folk music?",
            "options" to listOf("Harp", "Ukulele", "Baglama", "Yaktaro"),
            "correctAnswer" to "Yaktaro",
            "explanation" to "The yaktaro is a traditional one-string instrument used in Sindhi folk music.",
            "isActive" to true,
            "order" to 235
        ),
        mapOf(
            "id" to 266,
            "categoryId" to "pakistan_culture",
            "question" to "Which Pakistani city is famous for its historic Badshahi Mosque?",
            "options" to listOf("Karachi", "Quetta", "Islamabad", "Lahore"),
            "correctAnswer" to "Lahore",
            "explanation" to "The Badshahi Mosque is a major Mughal-era landmark in Lahore.",
            "isActive" to true,
            "order" to 236
        ),
        mapOf(
            "id" to 267,
            "categoryId" to "pakistan_culture",
            "question" to "Which Mughal-era garden in Lahore is a UNESCO World Heritage Site along with the Lahore Fort?",
            "options" to listOf("Shalimar Gardens", "Fatima Jinnah Park", "Ayub National Park", "Jilani Park"),
            "correctAnswer" to "Shalimar Gardens",
            "explanation" to "The Lahore Fort and Shalimar Gardens are jointly listed as a UNESCO World Heritage property.",
            "isActive" to true,
            "order" to 237
        ),
        mapOf(
            "id" to 268,
            "categoryId" to "pakistan_culture",
            "question" to "Which historic fort is a landmark of the Cholistan Desert near Bahawalpur?",
            "options" to listOf("Bala Hissar Fort", "Derawar Fort", "Rohtas Fort", "Ranikot Fort"),
            "correctAnswer" to "Derawar Fort",
            "explanation" to "Derawar Fort is a prominent historic fort in the Cholistan Desert near Bahawalpur; it is not listed as an inscribed UNESCO World Heritage Site.",
            "isActive" to true,
            "order" to 238
        ),
        mapOf(
            "id" to 269,
            "categoryId" to "pakistan_culture",
            "question" to "Which fort near Jhelum is a UNESCO World Heritage Site built under Sher Shah Suri?",
            "options" to listOf("Derawar Fort", "Lahore Fort", "Bala Hissar Fort", "Rohtas Fort"),
            "correctAnswer" to "Rohtas Fort",
            "explanation" to "Rohtas Fort was built in the 16th century under Sher Shah Suri.",
            "isActive" to true,
            "order" to 239
        ),
        mapOf(
            "id" to 270,
            "categoryId" to "pakistan_culture",
            "question" to "Which historic site in Sindh is famous for the Shah Jahan Mosque with elaborate tilework?",
            "options" to listOf("Khairpur", "Larkana", "Sukkur", "Thatta"),
            "correctAnswer" to "Thatta",
            "explanation" to "The Shah Jahan Mosque is in Thatta, Sindh.",
            "isActive" to true,
            "order" to 240
        ),
        mapOf(
            "id" to 271,
            "categoryId" to "pakistan_culture",
            "question" to "Which ancient Indus Valley Civilization site is located near Larkana in Sindh?",
            "options" to listOf("Harappa", "Taxila", "Makli", "Mohenjo-daro"),
            "correctAnswer" to "Mohenjo-daro",
            "explanation" to "Mohenjo-daro is a major archaeological site of the Indus Valley Civilization near Larkana.",
            "isActive" to true,
            "order" to 241
        ),
        mapOf(
            "id" to 272,
            "categoryId" to "pakistan_culture",
            "question" to "Which UNESCO-listed necropolis is located near Thatta in Sindh?",
            "options" to listOf("Makli Necropolis", "Mohenjo-daro", "Takht-i-Bahi", "Rohtas Fort"),
            "correctAnswer" to "Makli Necropolis",
            "explanation" to "Makli is a vast historic funerary site near Thatta.",
            "isActive" to true,
            "order" to 242
        ),
        mapOf(
            "id" to 273,
            "categoryId" to "pakistan_culture",
            "question" to "Which archaeological site near Mardan is famous for Buddhist monastery ruins?",
            "options" to listOf("Mohenjo-daro", "Taxila", "Harappa", "Takht-i-Bahi"),
            "correctAnswer" to "Takht-i-Bahi",
            "explanation" to "Takht-i-Bahi is a UNESCO-listed Buddhist monastic complex in Khyber Pakhtunkhwa.",
            "isActive" to true,
            "order" to 243
        ),
        mapOf(
            "id" to 274,
            "categoryId" to "pakistan_culture",
            "question" to "Which historic city near Rawalpindi is famous for Gandhara-era archaeological remains?",
            "options" to listOf("Gwadar", "Thatta", "Multan", "Taxila"),
            "correctAnswer" to "Taxila",
            "explanation" to "Taxila was an important ancient centre of learning and Gandhara civilization.",
            "isActive" to true,
            "order" to 244
        ),
        mapOf(
            "id" to 275,
            "categoryId" to "pakistan_culture",
            "question" to "Which Pakistani city is famous for its annual horse and cattle show?",
            "options" to listOf("Lahore", "Turbat", "Chitral", "Skardu"),
            "correctAnswer" to "Lahore",
            "explanation" to "The National Horse and Cattle Show has historically been associated with Lahore.",
            "isActive" to true,
            "order" to 245
        ),
        mapOf(
            "id" to 276,
            "categoryId" to "pakistan_culture",
            "question" to "Which region is famous for the traditional woollen cap called a pakol?",
            "options" to listOf("Lower Punjab only", "Northern Pakistan and Pashtun regions", "Coastal Sindh only", "Thar Desert only"),
            "correctAnswer" to "Northern Pakistan and Pashtun regions",
            "explanation" to "The pakol is worn in northern Pakistan and neighbouring Pashtun regions.",
            "isActive" to true,
            "order" to 246
        ),
        mapOf(
            "id" to 277,
            "categoryId" to "pakistan_culture",
            "question" to "Which textile is traditionally associated with the handwoven shawls of Kashmir and northern areas?",
            "options" to listOf("Truck art", "Ajrak", "Pashmina", "Balochi mirror work"),
            "correctAnswer" to "Pashmina",
            "explanation" to "Pashmina is a fine cashmere wool used for luxury shawls.",
            "isActive" to true,
            "order" to 247
        ),
        mapOf(
            "id" to 278,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is a major regional language of southern Punjab?",
            "options" to listOf("Shina", "Brahui", "Saraiki", "Balti"),
            "correctAnswer" to "Saraiki",
            "explanation" to "Saraiki is widely spoken in southern Punjab and adjoining regions.",
            "isActive" to true,
            "order" to 248
        ),
        mapOf(
            "id" to 279,
            "categoryId" to "pakistan_culture",
            "question" to "Which language is spoken in parts of northern Pakistan including Chitral?",
            "options" to listOf("Balochi", "Khowar", "Sindhi", "Saraiki"),
            "correctAnswer" to "Khowar",
            "explanation" to "Khowar is a major language of Chitral.",
            "isActive" to true,
            "order" to 249
        ),
        mapOf(
            "id" to 280,
            "categoryId" to "pakistan_culture",
            "question" to "Which regional language is spoken in parts of Gilgit-Baltistan?",
            "options" to listOf("Brahui", "Punjabi", "Sindhi", "Shina"),
            "correctAnswer" to "Shina",
            "explanation" to "Shina is spoken in parts of Gilgit-Baltistan and nearby areas.",
            "isActive" to true,
            "order" to 250
        ),
        mapOf(
            "id" to 281,
            "categoryId" to "pakistan_culture",
            "question" to "Which regional language is spoken by many communities in Baltistan?",
            "options" to listOf("Balti", "Saraiki", "Balochi", "Pashto"),
            "correctAnswer" to "Balti",
            "explanation" to "Balti is spoken in Baltistan in Gilgit-Baltistan.",
            "isActive" to true,
            "order" to 251
        ),
        mapOf(
            "id" to 282,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani physicist won the 1979 Nobel Prize in Physics?",
            "options" to listOf("Samar Mubarakmand", "Ishfaq Ahmad", "Abdul Qadeer Khan", "Abdus Salam"),
            "correctAnswer" to "Abdus Salam",
            "explanation" to "Abdus Salam shared the 1979 Nobel Prize in Physics for work on electroweak unification.",
            "isActive" to true,
            "order" to 252
        ),
        mapOf(
            "id" to 283,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani education activist shared the 2014 Nobel Peace Prize?",
            "options" to listOf("Malala Yousafzai", "Sharmeen Obaid-Chinoy", "Asma Jahangir", "Arfa Karim"),
            "correctAnswer" to "Malala Yousafzai",
            "explanation" to "Malala Yousafzai shared the Nobel Peace Prize in 2014.",
            "isActive" to true,
            "order" to 253
        ),
        mapOf(
            "id" to 284,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani computer prodigy became known internationally as a young Microsoft Certified Professional?",
            "options" to listOf("Malala Yousafzai", "Arfa Karim", "Samina Baig", "Nergis Mavalvala"),
            "correctAnswer" to "Arfa Karim",
            "explanation" to "Arfa Karim became known as a young Microsoft Certified Professional.",
            "isActive" to true,
            "order" to 254
        ),
        mapOf(
            "id" to 285,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani astrophysicist is known for work on gravitational waves and LIGO?",
            "options" to listOf("Nergis Mavalvala", "Samar Mubarakmand", "Arfa Karim", "Abdus Salam"),
            "correctAnswer" to "Nergis Mavalvala",
            "explanation" to "Nergis Mavalvala is a Pakistani-American astrophysicist known for work with LIGO.",
            "isActive" to true,
            "order" to 255
        ),
        mapOf(
            "id" to 286,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which city is a major centre for Pakistan’s surgical-instrument industry?",
            "options" to listOf("Sialkot", "Gwadar", "Chilas", "Sukkur"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot is known for surgical instruments and sports goods.",
            "isActive" to true,
            "order" to 256
        ),
        mapOf(
            "id" to 287,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which institution is Pakistan’s central bank?",
            "options" to listOf("Securities and Exchange Commission", "State Bank of Pakistan", "National Bank of Pakistan", "Federal Board of Revenue"),
            "correctAnswer" to "State Bank of Pakistan",
            "explanation" to "The State Bank of Pakistan is the country’s central bank.",
            "isActive" to true,
            "order" to 257
        ),
        mapOf(
            "id" to 288,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which organisation manages Pakistan’s national identity registration system?",
            "options" to listOf("NEPRA", "FBR", "PEMRA", "NADRA"),
            "correctAnswer" to "NADRA",
            "explanation" to "NADRA manages national identity registration and related records.",
            "isActive" to true,
            "order" to 258
        ),
        mapOf(
            "id" to 289,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which agency compiles Pakistan’s official statistics and census data?",
            "options" to listOf("Election Commission", "NADRA", "Pakistan Bureau of Statistics", "State Bank of Pakistan"),
            "correctAnswer" to "Pakistan Bureau of Statistics",
            "explanation" to "The Pakistan Bureau of Statistics produces official statistics and census data.",
            "isActive" to true,
            "order" to 259
        ),
        mapOf(
            "id" to 290,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which stock exchange operates as Pakistan’s main securities exchange?",
            "options" to listOf("Pakistan Stock Exchange", "State Bank Exchange", "Karachi Commodity Exchange", "Islamabad Securities Bureau"),
            "correctAnswer" to "Pakistan Stock Exchange",
            "explanation" to "The Pakistan Stock Exchange is the country’s principal stock exchange.",
            "isActive" to true,
            "order" to 260
        ),
        mapOf(
            "id" to 291,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani city is a major centre for textile manufacturing?",
            "options" to listOf("Faisalabad", "Chitral", "Gwadar", "Skardu"),
            "correctAnswer" to "Faisalabad",
            "explanation" to "Faisalabad is a major textile and industrial centre.",
            "isActive" to true,
            "order" to 261
        ),
        mapOf(
            "id" to 292,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which crop is a major raw material for Pakistan’s textile industry?",
            "options" to listOf("Cotton", "Rubber", "Coffee", "Tea"),
            "correctAnswer" to "Cotton",
            "explanation" to "Cotton is a key crop and raw material for Pakistan’s textile sector.",
            "isActive" to true,
            "order" to 262
        ),
        mapOf(
            "id" to 293,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which crop is especially associated with sugar production in Pakistan?",
            "options" to listOf("Olives only", "Cocoa", "Sugarcane", "Tea"),
            "correctAnswer" to "Sugarcane",
            "explanation" to "Sugarcane is a major crop used in Pakistan’s sugar industry.",
            "isActive" to true,
            "order" to 263
        ),
        mapOf(
            "id" to 294,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which province is a major producer of natural gas from the Sui field?",
            "options" to listOf("Gilgit-Baltistan", "Sindh only", "Punjab", "Balochistan"),
            "correctAnswer" to "Balochistan",
            "explanation" to "The Sui gas field is in Balochistan.",
            "isActive" to true,
            "order" to 264
        ),
        mapOf(
            "id" to 295,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which energy source is generated using flowing or falling water?",
            "options" to listOf("Geothermal power", "Hydroelectric power", "Solar thermal only", "Tidal power only"),
            "correctAnswer" to "Hydroelectric power",
            "explanation" to "Hydroelectric power converts water energy into electricity.",
            "isActive" to true,
            "order" to 265
        ),
        mapOf(
            "id" to 296,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani research organisation is associated with the country’s space programme?",
            "options" to listOf("NEPRA", "SUPARCO", "NADRA", "PCSIR"),
            "correctAnswer" to "SUPARCO",
            "explanation" to "SUPARCO is Pakistan’s national space agency.",
            "isActive" to true,
            "order" to 266
        ),
        mapOf(
            "id" to 297,
            "categoryId" to "pakistan_science_sports",
            "question" to "What does SUPARCO stand for?",
            "options" to listOf("Scientific University and Aerospace Council", "Satellite and Universal Research Council", "Space and Upper Atmosphere Research Commission", "Space Utility and Aviation Regulation Commission"),
            "correctAnswer" to "Space and Upper Atmosphere Research Commission",
            "explanation" to "SUPARCO is Pakistan’s Space and Upper Atmosphere Research Commission.",
            "isActive" to true,
            "order" to 267
        ),
        mapOf(
            "id" to 298,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani organisation conducts national nuclear research and development?",
            "options" to listOf("Pakistan Cricket Board", "Pakistan Bureau of Statistics", "NADRA", "Pakistan Atomic Energy Commission"),
            "correctAnswer" to "Pakistan Atomic Energy Commission",
            "explanation" to "PAEC is responsible for nuclear science and related programmes in Pakistan.",
            "isActive" to true,
            "order" to 268
        ),
        mapOf(
            "id" to 299,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani city is home to the Pakistan Aeronautical Complex?",
            "options" to listOf("Kamra", "Hyderabad", "Quetta", "Gwadar"),
            "correctAnswer" to "Kamra",
            "explanation" to "Pakistan Aeronautical Complex is located at Kamra in Punjab.",
            "isActive" to true,
            "order" to 269
        ),
        mapOf(
            "id" to 300,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which sport is Pakistan especially known for historically at the international level?",
            "options" to listOf("American football", "Ice hockey", "Field hockey", "Baseball"),
            "correctAnswer" to "Field hockey",
            "explanation" to "Pakistan has a distinguished history in international field hockey, including Olympic and World Cup titles.",
            "isActive" to true,
            "order" to 270
        ),
        mapOf(
            "id" to 301,
            "categoryId" to "pakistan_science_sports",
            "question" to "How many players from one team are on the field in standard field hockey?",
            "options" to listOf("Twelve", "Nine", "Seven", "Eleven"),
            "correctAnswer" to "Eleven",
            "explanation" to "A field hockey team has eleven players on the field, including the goalkeeper.",
            "isActive" to true,
            "order" to 271
        ),
        mapOf(
            "id" to 302,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani squash player won multiple World Open titles in the 1980s and 1990s?",
            "options" to listOf("Aisam-ul-Haq Qureshi", "Jansher Khan", "Jahangir Khan", "Shoaib Akhtar"),
            "correctAnswer" to "Jahangir Khan",
            "explanation" to "Jahangir Khan dominated international squash during the 1980s.",
            "isActive" to true,
            "order" to 272
        ),
        mapOf(
            "id" to 303,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani squash player won six consecutive World Open titles from 1989 to 1996?",
            "options" to listOf("Jansher Khan", "Qamar Zaman", "Hashim Khan", "Jahangir Khan"),
            "correctAnswer" to "Jansher Khan",
            "explanation" to "Jansher Khan won six consecutive World Open titles in that period.",
            "isActive" to true,
            "order" to 273
        ),
        mapOf(
            "id" to 304,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani cricketer is nicknamed “Sultan of Swing”?",
            "options" to listOf("Shahid Afridi", "Waqar Younis", "Wasim Akram", "Inzamam-ul-Haq"),
            "correctAnswer" to "Wasim Akram",
            "explanation" to "Wasim Akram is widely known as the Sultan of Swing.",
            "isActive" to true,
            "order" to 274
        ),
        mapOf(
            "id" to 305,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani fast bowler was known for reverse swing and the nickname “Burewala Express”?",
            "options" to listOf("Wasim Akram", "Waqar Younis", "Imran Khan", "Shoaib Akhtar"),
            "correctAnswer" to "Waqar Younis",
            "explanation" to "Waqar Younis was a renowned fast bowler known for reverse swing.",
            "isActive" to true,
            "order" to 275
        ),
        mapOf(
            "id" to 306,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani fast bowler was nicknamed the “Rawalpindi Express”?",
            "options" to listOf("Mohammad Sami", "Shoaib Akhtar", "Waqar Younis", "Wasim Akram"),
            "correctAnswer" to "Shoaib Akhtar",
            "explanation" to "Shoaib Akhtar was known as the Rawalpindi Express.",
            "isActive" to true,
            "order" to 276
        ),
        mapOf(
            "id" to 307,
            "categoryId" to "pakistan_science_sports",
            "question" to "Who captained Pakistan to victory in the 1992 Cricket World Cup?",
            "options" to listOf("Wasim Akram", "Javed Miandad", "Imran Khan", "Inzamam-ul-Haq"),
            "correctAnswer" to "Imran Khan",
            "explanation" to "Imran Khan captained Pakistan to its first men’s ODI Cricket World Cup title in 1992.",
            "isActive" to true,
            "order" to 277
        ),
        mapOf(
            "id" to 308,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which city hosted the final of the 1992 Cricket World Cup?",
            "options" to listOf("Melbourne", "Karachi", "Sydney", "Lahore"),
            "correctAnswer" to "Melbourne",
            "explanation" to "The 1992 final was played at the Melbourne Cricket Ground in Australia.",
            "isActive" to true,
            "order" to 278
        ),
        mapOf(
            "id" to 309,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani tennis player reached the men’s doubles final at the 2010 US Open?",
            "options" to listOf("Aisam-ul-Haq Qureshi", "Aqeel Khan", "Shoaib Malik", "Jahangir Khan"),
            "correctAnswer" to "Aisam-ul-Haq Qureshi",
            "explanation" to "Aisam-ul-Haq Qureshi reached the 2010 US Open men’s doubles final with Rohan Bopanna.",
            "isActive" to true,
            "order" to 279
        ),
        mapOf(
            "id" to 310,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani mountaineer became the first Pakistani woman to summit Mount Everest?",
            "options" to listOf("Nergis Mavalvala", "Samina Baig", "Malala Yousafzai", "Arfa Karim"),
            "correctAnswer" to "Samina Baig",
            "explanation" to "Samina Baig summited Mount Everest in 2013.",
            "isActive" to true,
            "order" to 280
        ),
        mapOf(
            "id" to 311,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani mountaineer was known for high-altitude climbs including K2 winter expeditions?",
            "options" to listOf("Muhammad Ali Sadpara", "Nergis Mavalvala", "Samina Baig", "Jahangir Khan"),
            "correctAnswer" to "Muhammad Ali Sadpara",
            "explanation" to "Muhammad Ali Sadpara was a prominent Pakistani high-altitude mountaineer.",
            "isActive" to true,
            "order" to 281
        ),
        mapOf(
            "id" to 312,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani climber was the first Pakistani to summit K2?",
            "options" to listOf("Ali Sadpara", "Ashraf Aman", "Samina Baig", "Nirmal Purja"),
            "correctAnswer" to "Ashraf Aman",
            "explanation" to "Ashraf Aman became the first Pakistani to summit K2 in 1977.",
            "isActive" to true,
            "order" to 282
        ),
        mapOf(
            "id" to 313,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which national sport is commonly cited in Pakistan’s school-level general knowledge?",
            "options" to listOf("Cricket", "Field hockey", "Polo", "Squash"),
            "correctAnswer" to "Field hockey",
            "explanation" to "Field hockey is commonly described as Pakistan’s national sport, though official designation is sometimes discussed.",
            "isActive" to true,
            "order" to 283
        ),
        mapOf(
            "id" to 314,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani city is home to the National Cricket Academy and major cricket facilities at Gaddafi Stadium?",
            "options" to listOf("Quetta", "Gilgit", "Gwadar", "Lahore"),
            "correctAnswer" to "Lahore",
            "explanation" to "Gaddafi Stadium and major cricket facilities are in Lahore.",
            "isActive" to true,
            "order" to 284
        ),
        mapOf(
            "id" to 315,
            "categoryId" to "pakistan_science_sports",
            "question" to "What is the name of Pakistan’s national cricket governing body?",
            "options" to listOf("Pakistan Sports Board", "Pakistan Hockey Federation", "Pakistan Cricket Board", "Pakistan Olympic Committee"),
            "correctAnswer" to "Pakistan Cricket Board",
            "explanation" to "The Pakistan Cricket Board governs cricket in Pakistan.",
            "isActive" to true,
            "order" to 285
        ),
        mapOf(
            "id" to 316,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani athlete won the men’s javelin throw gold medal at the 2022 Commonwealth Games?",
            "options" to listOf("Arshad Nadeem", "Abdul Khaliq", "Talha Talib", "Naseem Hameed"),
            "correctAnswer" to "Arshad Nadeem",
            "explanation" to "Arshad Nadeem won javelin gold at the 2022 Commonwealth Games.",
            "isActive" to true,
            "order" to 286
        ),
        mapOf(
            "id" to 317,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani athlete won Olympic gold in men’s javelin at Paris 2024?",
            "options" to listOf("Jahangir Khan", "Arshad Nadeem", "Aisam-ul-Haq Qureshi", "Shoaib Akhtar"),
            "correctAnswer" to "Arshad Nadeem",
            "explanation" to "Arshad Nadeem won Olympic gold in the men’s javelin throw at Paris 2024.",
            "isActive" to true,
            "order" to 287
        ),
        mapOf(
            "id" to 318,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani city is famous for producing hand-stitched footballs used worldwide?",
            "options" to listOf("Karachi", "Sialkot", "Quetta", "Lahore"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot is a globally known football-manufacturing centre.",
            "isActive" to true,
            "order" to 288
        ),
        mapOf(
            "id" to 319,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani company town is a major centre for surgical instruments and sports goods exports?",
            "options" to listOf("Chilas", "Sialkot", "Mardan", "Sukkur"),
            "correctAnswer" to "Sialkot",
            "explanation" to "Sialkot’s export industries include sporting goods and surgical instruments.",
            "isActive" to true,
            "order" to 289
        ),
        mapOf(
            "id" to 320,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani institution regulates electricity and power-sector licensing?",
            "options" to listOf("NADRA", "NEPRA", "PEMRA", "FBR"),
            "correctAnswer" to "NEPRA",
            "explanation" to "NEPRA is the National Electric Power Regulatory Authority.",
            "isActive" to true,
            "order" to 290
        ),
        mapOf(
            "id" to 321,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which authority regulates electronic media in Pakistan?",
            "options" to listOf("PEMRA", "NADRA", "NEPRA", "SECP"),
            "correctAnswer" to "PEMRA",
            "explanation" to "PEMRA is the Pakistan Electronic Media Regulatory Authority.",
            "isActive" to true,
            "order" to 291
        ),
        mapOf(
            "id" to 322,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which institution regulates companies and capital markets in Pakistan?",
            "options" to listOf("SECP", "NEPRA", "NADRA", "PEMRA"),
            "correctAnswer" to "SECP",
            "explanation" to "The Securities and Exchange Commission of Pakistan regulates companies and capital markets.",
            "isActive" to true,
            "order" to 292
        ),
        mapOf(
            "id" to 323,
            "categoryId" to "pakistan_science_sports",
            "question" to "What does FBR stand for in Pakistan?",
            "options" to listOf("Federal Budget Review", "Federal Board of Revenue", "Federal Banking Registry", "Finance Bureau of Regulation"),
            "correctAnswer" to "Federal Board of Revenue",
            "explanation" to "The FBR administers federal tax collection in Pakistan.",
            "isActive" to true,
            "order" to 293
        ),
        mapOf(
            "id" to 324,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani city is a major hub for automobile assembly and manufacturing?",
            "options" to listOf("Karachi", "Skardu", "Turbat", "Chitral"),
            "correctAnswer" to "Karachi",
            "explanation" to "Karachi hosts major automobile assembly and manufacturing facilities.",
            "isActive" to true,
            "order" to 294
        ),
        mapOf(
            "id" to 325,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which crop is Pakistan especially known for producing in the Punjab and Sindh plains?",
            "options" to listOf("Rubber", "Cocoa", "Wheat", "Coffee"),
            "correctAnswer" to "Wheat",
            "explanation" to "Wheat is a major staple crop grown across Pakistan’s irrigated plains.",
            "isActive" to true,
            "order" to 295
        ),
        mapOf(
            "id" to 326,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which irrigation system is central to agriculture in Pakistan’s Indus basin?",
            "options" to listOf("Murray-Darling System", "Nile Delta System", "Indus Basin Irrigation System", "Amazon Canal System"),
            "correctAnswer" to "Indus Basin Irrigation System",
            "explanation" to "The Indus Basin Irrigation System is one of the world’s largest contiguous irrigation systems.",
            "isActive" to true,
            "order" to 296
        ),
        mapOf(
            "id" to 327,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani scientist was a leading figure in the country’s nuclear test programme at Chagai?",
            "options" to listOf("Abdus Salam", "Samar Mubarakmand", "Nergis Mavalvala", "Arfa Karim"),
            "correctAnswer" to "Samar Mubarakmand",
            "explanation" to "Samar Mubarakmand led scientific teams associated with the 1998 nuclear tests.",
            "isActive" to true,
            "order" to 297
        ),
        mapOf(
            "id" to 328,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which year did Pakistan conduct its nuclear tests in the Chagai Hills?",
            "options" to listOf("1993", "1998", "2001", "1988"),
            "correctAnswer" to "1998",
            "explanation" to "Pakistan conducted nuclear tests on 28 May 1998.",
            "isActive" to true,
            "order" to 298
        ),
        mapOf(
            "id" to 329,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani institution is responsible for meteorological forecasts and weather observations?",
            "options" to listOf("Pakistan Cricket Board", "NADRA", "SUPARCO only", "Pakistan Meteorological Department"),
            "correctAnswer" to "Pakistan Meteorological Department",
            "explanation" to "The Pakistan Meteorological Department monitors weather, climate and related hazards.",
            "isActive" to true,
            "order" to 299
        ),
        mapOf(
            "id" to 330,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which Pakistani organisation researches industrial and applied sciences?",
            "options" to listOf("NEPRA", "PCSIR", "PEMRA", "NADRA"),
            "correctAnswer" to "PCSIR",
            "explanation" to "PCSIR is the Pakistan Council of Scientific and Industrial Research.",
            "isActive" to true,
            "order" to 300
        ),
        mapOf(
            "id" to 331,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which renewable energy technology converts sunlight directly into electricity using photovoltaic cells?",
            "options" to listOf("Hydroelectric power", "Coal gasification", "Nuclear fission", "Solar photovoltaic power"),
            "correctAnswer" to "Solar photovoltaic power",
            "explanation" to "Photovoltaic cells convert sunlight directly into electrical energy.",
            "isActive" to true,
            "order" to 301
        ),
        mapOf(
            "id" to 332,
            "categoryId" to "pakistan_science_sports",
            "question" to "Which port is a major deep-water port near Karachi and part of Pakistan’s maritime trade network?",
            "options" to listOf("Wagah", "Khunjerab", "Port Qasim", "Torkham"),
            "correctAnswer" to "Port Qasim",
            "explanation" to "Port Qasim is a major seaport near Karachi.",
            "isActive" to true,
            "order" to 302
        ),
        mapOf(
            "id" to 333,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which monetary unit is used in Pakistan?",
            "options" to listOf("Afghani", "Taka", "Riyal", "Pakistani rupee"),
            "correctAnswer" to "Pakistani rupee",
            "explanation" to "The Pakistani rupee is the country’s official currency.",
            "isActive" to true,
            "order" to 303
        ),
        mapOf(
            "id" to 334,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which telephone country prefix is used to call Pakistan internationally?",
            "options" to listOf("+93", "+92", "+94", "+91"),
            "correctAnswer" to "+92",
            "explanation" to "Pakistan’s international telephone country code is +92.",
            "isActive" to true,
            "order" to 304
        ),
        mapOf(
            "id" to 335,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which side of the road do vehicles normally drive on in Pakistan?",
            "options" to listOf("Centre only", "Right", "It varies by province", "Left"),
            "correctAnswer" to "Left",
            "explanation" to "Road traffic in Pakistan normally keeps to the left.",
            "isActive" to true,
            "order" to 305
        ),
        mapOf(
            "id" to 336,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "What is Pakistan’s internet country-code top-level domain?",
            "options" to listOf(".pk", ".pa", ".pn", ".ps"),
            "correctAnswer" to ".pk",
            "explanation" to ".pk is the country-code top-level domain for Pakistan.",
            "isActive" to true,
            "order" to 306
        ),
        mapOf(
            "id" to 337,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which body conducts general elections in Pakistan?",
            "options" to listOf("State Bank of Pakistan", "Election Commission of Pakistan", "Pakistan Bureau of Statistics", "NADRA alone"),
            "correctAnswer" to "Election Commission of Pakistan",
            "explanation" to "The Election Commission of Pakistan administers elections under the Constitution and election laws.",
            "isActive" to true,
            "order" to 307
        ),
        mapOf(
            "id" to 338,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which city is the federal capital of Pakistan?",
            "options" to listOf("Lahore", "Karachi", "Islamabad", "Rawalpindi"),
            "correctAnswer" to "Islamabad",
            "explanation" to "Islamabad is Pakistan’s federal capital.",
            "isActive" to true,
            "order" to 308
        ),
        mapOf(
            "id" to 339,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which flower is recognised as Pakistan’s national floral emblem?",
            "options" to listOf("Rose", "Jasmine", "Tulip", "Sunflower"),
            "correctAnswer" to "Jasmine",
            "explanation" to "Jasmine is commonly recognised as Pakistan’s national flower.",
            "isActive" to true,
            "order" to 309
        ),
        mapOf(
            "id" to 340,
            "categoryId" to "pakistan_general_knowledge",
            "question" to "Which wild goat species is recognised as Pakistan’s national animal?",
            "options" to listOf("Markhor", "Snow leopard", "Chinkara", "Lion"),
            "correctAnswer" to "Markhor",
            "explanation" to "The markhor is Pakistan’s national animal.",
            "isActive" to true,
            "order" to 310
        )
    )
}
