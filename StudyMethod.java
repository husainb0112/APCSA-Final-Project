// StudyMethod.java
// Holds study resources and selects methods based on unit and time.
public class StudyMethod {
    private Flashcard[] flashcards;     // Flashcards to study
    private Quiz[] quizzes;             // Quizzes to take
    private ErrorAnalysis errorAnalysis; // Errors to review
    private Review review;              // Notes for review

    public StudyMethod(Flashcard[] flashcards, Quiz[] quizzes, ErrorAnalysis errorAnalysis, Review review) {
        this.flashcards = flashcards;
        this.quizzes = quizzes;
        this.errorAnalysis = errorAnalysis;
        this.review = review;
    }

    public Flashcard[] getFlashcards() {
        return flashcards;
    }

    public Quiz[] getQuizzes() {
        return quizzes;
    }

    public ErrorAnalysis getErrorAnalysis() {
        return errorAnalysis;
    }

    public Review getReview() {
        return review;
    }

    // Returns appropriate study materials based on time and selected unit
    public static StudyMethod[] selectMethods(int time, Unit unit) {
        Flashcard[] flashcards = null;
        Quiz[] quizzes = null;
        ErrorAnalysis errorAnalysis = null;
        Review review = null;

        String unitName = unit.getName();

        // Setup study materials for each AP Stats unit
        if (unitName.contains("Unit 1")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is the difference between population and sample?", 
                              "Population is the entire group; sample is a subset."),
                new Flashcard("Define bias in sampling.", "Bias occurs when sample is not representative."),
                new Flashcard("What is a convenience sample?", 
                              "Sampling individuals easiest to reach, which can cause bias.")
            };
            quizzes = new Quiz[] {
                new Quiz("Which is an example of a biased sample?", 
                         new String[] {"Random selection", "Convenience sample", "Stratified sample"}, 
                         "Convenience sample"),
                new Quiz("True or False: Observational studies manipulate variables.", 
                         new String[] {"True", "False"}, "False")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Mixing up population and sample.",
                "Failing to recognize sampling bias."
            });
            review = new Review(new String[] {
                "Sampling methods affect study validity.",
                "Observational studies do not imply causation."
            });
        } else if (unitName.contains("Unit 2")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is a normal distribution?", 
                              "A symmetric, bell-shaped distribution defined by mean and SD."),
                new Flashcard("What does the 68-95-99.7 rule describe?", 
                              "Percentages of data within 1, 2, and 3 SDs in a normal distribution."),
                new Flashcard("How do you standardize a value?", 
                              "Subtract mean and divide by standard deviation.")
            };
            quizzes = new Quiz[] {
                new Quiz("What percent of data falls within 2 standard deviations in a normal distribution?", 
                         new String[] {"68%", "95%", "99.7%"}, "95%"),
                new Quiz("True or False: A z-score can be negative.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Confusing variance with standard deviation.",
                "Misapplying the empirical rule percentages."
            });
            review = new Review(new String[] {
                "Standardizing values allows comparisons across distributions.",
                "Normal models are useful but must check for normality."
            });
        } else if (unitName.contains("Unit 3")) {
            flashcards = new Flashcard[] {
                new Flashcard("What does correlation measure?", "The strength and direction of a linear relationship."),
                new Flashcard("What is the least squares regression line?", 
                              "Line minimizing the sum of squared residuals."),
                new Flashcard("Define outlier in regression context.", 
                              "A point far from the pattern that may influence the line.")
            };
            quizzes = new Quiz[] {
                new Quiz("If correlation is near zero, the data shows:", 
                         new String[] {"Strong linear relation", "No linear relation", "Perfect fit"}, 
                         "No linear relation"),
                new Quiz("True or False: A high correlation implies causation.", 
                         new String[] {"True", "False"}, "False")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Confusing correlation with causation.",
                "Ignoring outliers that affect regression."
            });
            review = new Review(new String[] {
                "Correlation ranges from -1 to 1.",
                "Residual plots help check regression assumptions."
            });
        } else if (unitName.contains("Unit 4")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is a parameter vs. statistic?", 
                              "Parameter describes a population; statistic describes a sample."),
                new Flashcard("Define sampling distribution.", 
                              "The distribution of a sample statistic over many samples."),
                new Flashcard("What is the Central Limit Theorem?", 
                              "Sample means approximate a normal distribution as sample size grows.")
            };
            quizzes = new Quiz[] {
                new Quiz("What happens to the shape of sampling distribution as sample size increases?", 
                         new String[] {"Becomes more skewed", "Approaches normal", "Remains unchanged"}, 
                         "Approaches normal"),
                new Quiz("True or False: Parameters are usually known values.", 
                         new String[] {"True", "False"}, "False")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Confusing parameter and statistic.",
                "Misunderstanding the CLT conditions."
            });
            review = new Review(new String[] {
                "Sampling distributions explain variability of sample statistics.",
                "CLT allows use of normal models for inference."
            });
        } else if (unitName.contains("Unit 5")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is a confidence interval?", 
                              "Range of values to estimate a population parameter."),
                new Flashcard("Define margin of error.", 
                              "Amount the estimate can vary due to sampling."),
                new Flashcard("What confidence level means?", 
                              "The probability the interval contains the parameter.")
            };
            quizzes = new Quiz[] {
                new Quiz("A 95% confidence interval means:", 
                         new String[] {"95% of samples contain the parameter", 
                                       "There is 95% chance the parameter is in the interval", 
                                       "95% of intervals contain the parameter"}, 
                         "95% of intervals contain the parameter"),
                new Quiz("True or False: Larger sample size decreases margin of error.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Interpreting confidence intervals incorrectly.",
                "Ignoring sample size effect on margin of error."
            });
            review = new Review(new String[] {
                "Confidence intervals give a range for parameters.",
                "Increasing confidence level widens interval."
            });
        } else if (unitName.contains("Unit 6")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is a hypothesis test?", 
                              "Procedure to test claims about population parameters."),
                new Flashcard("Define null and alternative hypotheses.", 
                              "Null is status quo; alternative is what you want to prove."),
                new Flashcard("What is p-value?", 
                              "Probability of data as extreme as observed if null is true.")
            };
            quizzes = new Quiz[] {
                new Quiz("If p-value < significance level, what do you do?", 
                         new String[] {"Reject null", "Fail to reject null", "Accept alternative"}, 
                         "Reject null"),
                new Quiz("True or False: Failing to reject null proves it is true.", 
                         new String[] {"True", "False"}, "False")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Misinterpreting p-values.",
                "Confusing failing to reject with accepting null."
            });
            review = new Review(new String[] {
                "Hypothesis tests assess evidence against null hypothesis.",
                "Significance level sets cutoff for rejecting null."
            });
        } else if (unitName.contains("Unit 7")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is a chi-square test?", 
                              "Test for relationships in categorical data."),
                new Flashcard("Define expected counts.", 
                              "Counts expected if null hypothesis is true."),
                new Flashcard("What conditions are needed for chi-square tests?", 
                              "Sufficient sample size and independence.")
            };
            quizzes = new Quiz[] {
                new Quiz("Chi-square tests are used for:", 
                         new String[] {"Quantitative data", "Categorical data", "Both"}, "Categorical data"),
                new Quiz("True or False: Chi-square statistic measures difference between observed and expected counts.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Not checking conditions before applying chi-square test.",
                "Misreading p-values in chi-square context."
            });
            review = new Review(new String[] {
                "Chi-square tests analyze categorical relationships.",
                "Large chi-square values mean data differ from null."
            });
        } else if (unitName.contains("Unit 8")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is regression inference?", 
                              "Using sample data to infer about population regression."),
                new Flashcard("Define slope and intercept in regression.", 
                              "Slope shows change in response per explanatory unit; intercept is predicted value when explanatory=0."),
                new Flashcard("What are conditions for regression inference?", 
                              "Linearity, independence, normal residuals, equal variance.")
            };
            quizzes = new Quiz[] {
                new Quiz("Which condition is NOT required for regression inference?", 
                         new String[] {"Linearity", "Equal variance", "Large sample size", "Independence"}, 
                         "Large sample size"),
                new Quiz("True or False: Residual plots check regression assumptions.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Failing to check regression conditions.",
                "Misinterpreting slope significance."
            });
            review = new Review(new String[] {
                "Regression inference estimates population parameters.",
                "Diagnostics ensure model validity."
            });
        } else if (unitName.contains("Unit 9")) {
            flashcards = new Flashcard[] {
                new Flashcard("What is simulation in statistics?", 
                              "Using randomization to model chance behavior."),
                new Flashcard("Define randomization test.", 
                              "Testing hypotheses using simulated samples."),
                new Flashcard("When is simulation useful?", 
                              "When theoretical distributions are hard to derive.")
            };
            quizzes = new Quiz[] {
                new Quiz("Simulation is especially useful when:", 
                         new String[] {"Exact formulas exist", "Sample sizes are large", "Theoretical models fail"}, 
                         "Theoretical models fail"),
                new Quiz("True or False: Randomization test relies on resampling data.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Confusing simulation with analytic methods.",
                "Not setting up proper randomization protocols."
            });
            review = new Review(new String[] {
                "Simulations approximate probabilities using repeated trials.",
                "Randomization tests provide flexible hypothesis testing."
            });
        } else {
            // Generic fallback materials
            flashcards = new Flashcard[] {
                new Flashcard("Review key terms and concepts for this unit.", 
                              "Use your class notes and textbook."),
            };
            quizzes = new Quiz[] {
                new Quiz("Select True or False: This is a placeholder quiz.", 
                         new String[] {"True", "False"}, "True")
            };
            errorAnalysis = new ErrorAnalysis(new String[] {
                "Make sure to review all errors from homework and tests."
            });
            review = new Review(new String[] {
                "Review class notes regularly.",
                "Ask questions about unclear topics."
            });
        }

        // Return study methods depending on available time
        if (time < 10) {
            return new StudyMethod[] { new StudyMethod(flashcards, null, null, null) };
        } else if (time <= 30) {
            return new StudyMethod[] { new StudyMethod(flashcards, quizzes, null, null) };
        } else if (time <= 60) {
            return new StudyMethod[] { new StudyMethod(flashcards, quizzes, errorAnalysis, null) };
        } else if (time <= 120) {
            return new StudyMethod[] { new StudyMethod(flashcards, quizzes, errorAnalysis, review) };
        } else {
            // Over 120 minutes, suggest extended study including all materials twice
            return new StudyMethod[] {
                new StudyMethod(flashcards, quizzes, errorAnalysis, review),
                new StudyMethod(flashcards, quizzes, errorAnalysis, review)
            };
        }
    }
}


